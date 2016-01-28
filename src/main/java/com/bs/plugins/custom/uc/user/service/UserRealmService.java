package com.bs.plugins.custom.uc.user.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bs.plugins.custom.uc.organization.entity.Organization;
import com.bs.plugins.custom.uc.organization.service.OrganizationService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.bs.core.service.SpringContextUtil;
import com.bs.plugins.custom.uc.authorization.entity.Authorization;
import com.bs.plugins.custom.uc.authorization.service.AuthorizationService;
import com.bs.plugins.custom.uc.role.entity.Role;
import com.bs.plugins.custom.uc.role.service.RoleService;
import com.bs.plugins.custom.uc.user.entity.User;

public class UserRealmService extends AuthorizingRealm{

	/**
	 * 处理用户权限的方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null) {
			throw new AuthorizationException("User AuthorizationInfo not null");
		}
		User user = (User) getAvailablePrincipal(principals);
		String username = user.getAccount();
		Set<String> roleIds = null;
		Set<String> authorizations = null;
		try {
			//如果是超级管理员type==0
			if (user.getType() != null && user.getType() == 0){
				roleIds = new HashSet<String>();
				authorizations = new HashSet<String>();
				roleIds.add("*");
				authorizations.add("*");
			}
			else{
				//根据用户名查询权限是否具备
				roleIds = getUserRoles(user);
				Authorization authorization = new Authorization();
				authorization.setRoleId(roleIds);
				authorizations = getAuthorizations(authorization);
			}
		} catch (Exception e) {
			final String message = "get[" + username + "] AuthorizationInfo error！";
			throw new AuthorizationException(message, e);
		}
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roleIds);
		simpleAuthorizationInfo.setStringPermissions(authorizations);
		return simpleAuthorizationInfo;
	}

	/**
	 * 处理身份验证的服务方法
	 */
	@Override					
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		if (username == null) {
			throw new AccountException("Username not null！");
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = null;
		try {
			User user = getUserByAccount(username);

			if (user != null){
				String password = user.getPassword();
				if (password != null) {
					//用户启用状态
					if(user.getStatus()==1){
						//查看用户角色是否全部禁用
						user=queryRoleIsDisabled(username);
						if(user!=null){
							simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, password, getName());
							//simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username));
						}else{
							throw new UnknownAccountException("User disabled： [" + username + "] ");
						}
					}else{
						throw new UnknownAccountException("Account： [" + username + "] forbidden");
					}
				}else{
					throw new UnknownAccountException("UnknownAccount： [" + username + "]");
				}
			}
			else{
				throw new UnknownAccountException("UnknownAccount： [" + username + "]");
			}

			String orgCode = user.getOrgCode();
			if(StringUtils.isNotBlank(orgCode)){
				Organization organization = getOrgByOrgCode(orgCode);
				user.setOrganization(organization);
			}
		} catch (UnknownAccountException e) {
			throw e;
		} catch (Exception e) {
			final String message = "get[" + username + "]AccountInfo error！";
			throw new AuthenticationException(message, e);
		}
		
		return simpleAuthenticationInfo;
	}	
	
	protected Set<String> getAuthorizations(Authorization authorization) throws Exception {
		Set<String> authorizationSet = new HashSet<String>();
		AuthorizationService authorizationService = (AuthorizationService) SpringContextUtil.getBean("authorizationService");
		List<Authorization> listAuthorizations = authorizationService.getAuthsByRoleIds(authorization);
		if (listAuthorizations != null && listAuthorizations.size() > 0){
			for(Authorization authorizationTemp:listAuthorizations){
				String referenceIndex = authorizationTemp.getCode();
				authorizationSet.add(referenceIndex);
			}
		}
		return authorizationSet;
	}

	/**
	 * 根据账号信息获取说有角色ID信息
	 * @param account
	 * @return
	 * @throws Exception
	 */
	protected Set<String> getUserRoles(User user) throws Exception {
		Set<String> roleSet = new HashSet<String>();
		RoleService roleService = (RoleService) SpringContextUtil.getBean("roleService");
		List<Role> listRoles = roleService.getRolesByAccount(user);
		if (listRoles != null && listRoles.size() > 0){
			for(Role role:listRoles){
				Long rid = role.getId();
				roleSet.add(String.valueOf(rid));
			}
		}
		return roleSet;
	}

	/**
	 * 根据ID获取用户信息
	 * @param account
	 * @return
	 * @throws Exception
	 */
	protected User getUserByAccount(String account) throws Exception {
		User user = new User();
		try{
			user.setAccount(account);
			UserService userService = (UserService) SpringContextUtil.getBean("userService");
			user = userService.getUserPassword(user);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 根据ID获取用户信息
	 * @param account
	 * @return
	 * @throws Exception
	 */
	protected Organization getOrgByOrgCode(String orgCode) throws Exception {
		Organization organization = new Organization();
		try{
			organization.setCode(orgCode);
			OrganizationService organizationService = (OrganizationService) SpringContextUtil.getBean("organizationService");
			List<Organization> organizationList = organizationService.getOrganizationDao().selectList(organization);
			if(organizationList != null && organizationList.size() == 1) {
				return organizationList.get(0);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return organization;
	}

	/**
	 * 根据ID获取用户角色是否全部禁用
	 * @param account
	 * @return
	 * @throws Exception
	 */
	protected User queryRoleIsDisabled(String account) throws Exception {
		User user = new User();
		try{
			user.setAccount(account);
			UserService userService = (UserService) SpringContextUtil.getBean("userService");
			user = userService.queryRoleIsDisabled(user);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
}
