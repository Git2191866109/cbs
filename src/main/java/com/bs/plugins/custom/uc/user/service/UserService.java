package com.bs.plugins.custom.uc.user.service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.bs.core.entity.ResultData;
import com.bs.core.initialize.InitializeData;
import com.bs.core.service.IBaseService;
import com.bs.core.utils.Encrypt;
import com.bs.core.utils.PasswordUtil;
import com.bs.plugins.custom.uc.organization.service.OrganizationService;
import com.bs.plugins.custom.uc.user.base.BaseUserService;
import com.bs.plugins.custom.uc.user.entity.User;

@Service
public class UserService extends BaseUserService<User> {
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private  OrganizationService organizationService;
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData userIndex(User user){
		ResultData resultData = new ResultData();
		try {
			resultData=	organizationService.selectAll(resultData);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**
	 * 修改登录用户密码
	 * @param user
	 * @return
	 */
	public ResultData passwordIndex(User user){
		ResultData resultData = new ResultData();
		try {
			Subject currentUser = SecurityUtils.getSubject();
			if (currentUser != null){
				Object userObj = currentUser.getPrincipal();
				if (userObj instanceof User){
					User userTemp = (User)userObj;
					resultData.addObject("currentUser", userTemp);
				}
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(User user){
		ResultData resultData = new ResultData();
		try {
			resultData=super.single(user);
			//查询所属机构
			resultData=	organizationService.selectAll(resultData);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(User user){
		ResultData resultData = new ResultData();
		try {
			//add your code
			resultData=	organizationService.selectAll(resultData);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	/**跳转到列表**/
	public ResultData jumpList(User user){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}	
	
	/**跳转到分页列表**/
	public ResultData jumpPaginated(User user){
		ResultData resultData = new ResultData();
		try {
			//查询所有的管理员
			List<User> userList = super.getUserDao().findPaginatedList(user);
			Long userCount = super.getUserDao().getCount(user);
			//查询总条数
			if(userList!=null){
				long record = userCount == null?0:userCount;
				int pageCount = (int) Math.ceil(record / (double) user.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", user.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", userList);
				resultData.setResultMap(gridMap);
				resultData.setStatus(IBaseService.SUCCESS);
			}else{
				resultData.setStatus(IBaseService.FAIL);	
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	/**
	 * 禁用/启用 操作
	 * @param user
	 * @return
	 */
	public ResultData forbidden(User user){
		ResultData resultData = new ResultData();
		resultData= super.modifyById(user);
		return resultData;
	};
	
	
	/**
	 * 获取用户密码
	 * @param user
	 * @return
	 */
	public User getUserPassword(User user){
		try {
			Object userTemp = super.getUserDao().selectByAccount(user);
			if (userTemp instanceof User){
				user = (User) userTemp;
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *查看用户角色是否全部禁用
	 * @param user
	 * @return
	 */
	public User queryRoleIsDisabled(User user){
		try {
			Object userTemp = super.getUserDao().queryRoleIsDisabled(user);
			if (userTemp instanceof User){
				user = (User) userTemp;
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("initializing  administrator info.....");
		InitializeData initializeData = super.getInitializeData();
		if (initializeData != null){
			Map<String, List<Object>> data = initializeData.getConfigFileData();
			if (data != null){
				try{
					List<Object> userList = data.get("user");
					if (userList != null){
						for (Object obj:userList){
							if (obj instanceof User){
								User user = (User)obj;
								User userTemp = super.getUserDao().selectByAccount(user);
								if (userTemp == null){
									String password  = user.getPassword();
									user.setPassword(Encrypt.getMD5(password));
									int result = super.getUserDao().updateByAccount(user);
									if (result <= 0 ){
										super.getUserDao().insert(user);
									}
								}
								else{
									user.setPassword(null);
									super.getUserDao().updateByAccount(user);
								}
								logger.info("initializing  administrator info success!");
							}
						}
					}
				}
				catch(Exception e){
					logger.info("initializing  administrator info fail!");
				}
			}
		}
	}
	/**
	 * 创建管理员
	 * @param user
	 * @return
	 */
	public ResultData create(User user){
		ResultData resultData = new ResultData();
		try {
			BindingResult bindingResult = user.getBindingResult();
			if (bindingResult != null){
				String password = user.getPassword();
				if (password == null || password.equals("")){
					bindingResult.rejectValue("password", "NotEmpty");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
				String confirmPassword = user.getConfirmPassword();
				if (confirmPassword == null || confirmPassword.equals("")){
					bindingResult.rejectValue("confirmPassword", "NotEmpty");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
				if (!password.equals(confirmPassword)){
					bindingResult.rejectValue("confirmPassword", "Disaccord");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
			}
			user.setPassword(Encrypt.getMD5(user.getPassword()));
			int returValue = super.getUserDao().insert(user);
			if (returValue > 0){
				resultData.setStatus(SUCCESS);
			}
			else{
				resultData.setStatus(FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			resultData.setStatus(FAIL);
			e.printStackTrace();
		}
		return resultData;		
	}
	/**
	 * 修改管理员
	 * @param user
	 * @return
	 */
	public ResultData modify(User user){
		ResultData resultData = new ResultData();
		try {
			try {
				Integer result = super.getUserDao().updateByUserId(user);
				if (result > 0){
					resultData.setStatus(IBaseService.SUCCESS);
				}
				else{
					resultData.setStatus(IBaseService.FAIL);
				}
			} catch (Exception e) {
				resultData.setStatusException(e.getMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;		
	}
	/**
	 * 重置密码
	 * @param user
	 * @return
	 */
	public ResultData resetpwd(User user){
		ResultData resultData = new ResultData();
		try {
			BindingResult bindingResult = user.getBindingResult();
			String newPassword = user.getNewPassword();
			String confirmPassword = user.getConfirmPassword();
			if (bindingResult != null){
				if (newPassword == null || newPassword.equals("")){
					bindingResult.rejectValue("newPassword", "NotEmpty");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
				boolean isNewPassword = PasswordUtil.isPassword(newPassword);
				if (!isNewPassword){
					bindingResult.rejectValue("newPassword", "Pattern");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
				if (confirmPassword == null || confirmPassword.equals("")){
					bindingResult.rejectValue("confirmPassword", "NotEmpty");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
				if (!newPassword.equals(confirmPassword)){
					bindingResult.rejectValue("confirmPassword", "Disaccord");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
			}
			try {
				user.setPassword(Encrypt.getMD5(newPassword));
				Integer result = super.getUserDao().updateByUserId(user);
				if (result > 0) {
					resultData.setStatus(IBaseService.SUCCESS);
				} else {
					resultData.setStatus(IBaseService.FAIL);
				}
			} catch (Exception e) {
				resultData.setStatusException(e.getMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**
	 * 创建管理员
	 * @param user
	 * @return
	 */
	public ResultData modifypwd(User user){
		ResultData resultData = new ResultData();
		try {
			BindingResult bindingResult = user.getBindingResult();
			String oldPassword = user.getOldPassword();
			String newPassword = user.getNewPassword();
			String confirmPassword = user.getConfirmPassword();
			if (bindingResult != null){
				if (oldPassword == null || oldPassword.equals("")){
					bindingResult.rejectValue("oldPassword", "NotEmpty");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
				boolean isOldPassword = PasswordUtil.isPassword(oldPassword);
				if (!isOldPassword){
					bindingResult.rejectValue("oldPassword", "Pattern");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
				if (newPassword == null || newPassword.equals("")){
					bindingResult.rejectValue("newPassword", "NotEmpty");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
				boolean isNewPassword = PasswordUtil.isPassword(newPassword);
				if (!isNewPassword){
					bindingResult.rejectValue("newPassword", "Pattern");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
				if (confirmPassword == null || confirmPassword.equals("")){
					bindingResult.rejectValue("confirmPassword", "NotEmpty");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
				if (!newPassword.equals(confirmPassword)){
					bindingResult.rejectValue("confirmPassword", "Disaccord");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
			}
			Subject currentUser = SecurityUtils.getSubject();
			if (currentUser != null){
				Object userObj = currentUser.getPrincipal();
				if (userObj instanceof User){
					User userTemp = (User)userObj;
					//原始密码
					String oldPasswordTemp = userTemp.getPassword();
					//比较原始密码是否一致
					if (!oldPassword.equals(oldPasswordTemp)){
						bindingResult.rejectValue("oldPassword", "Disaccord");
						resultData.setBindingResult(bindingResult);
						return resultData;
					}
					String newPasswordTemp = Encrypt.getMD5(newPassword);
					userTemp.setPassword(newPasswordTemp);
					int returnValue = super.getUserDao().updateByUserId(userTemp);
					if (returnValue > 0){
						resultData.setStatus(SUCCESS);
					}
					else{
						resultData.setStatus(FAIL);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultData.setStatus(FAIL);
		}	
		return resultData;
	}

}