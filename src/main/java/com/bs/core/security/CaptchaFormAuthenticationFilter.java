package com.bs.core.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.common.Constant;
import com.bs.core.dao.IBaseRedisDao;
import com.bs.plugins.custom.uc.user.dao.IUserDao;
import com.bs.plugins.custom.uc.user.entity.User;
 
public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {

	private static final String DEFAULT_CAPTCHA_PARAM = "captcha";
	private String captchaParam = DEFAULT_CAPTCHA_PARAM;
	
	@Autowired
	private IBaseRedisDao<User> redisDao;
	
	@Autowired
	private IUserDao userDao;
	
	public CaptchaFormAuthenticationFilter(){
	}
	
	public String getCaptchaParam() {
		return captchaParam;
	}

	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}
	

	
	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		//CaptchaUsernamePasswordToken token = createToken(request, response);
		UsernamePasswordToken token = createToken(request, response);
		HttpServletRequest req = (HttpServletRequest) request;
		if (token == null) {
			throw new IllegalStateException("Can not create AuthenticationToken！");
		}
		token.setRememberMe(true);
		try {
			//Subject subject = getSubject(request, response);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
	//############################################################	
			
			/**
			User user = new User();
			user.setAccount(token.getUsername());
			user = userDao.selectByAccount(user);
			//登陆成功就将APP_ID+cookie+用户名作为KEY,User对象作为值存到redis,方便不同应用调取
			redisDao.add(APP_ID+req.getCookies()+user,user);
			*/
	//############################################################		
		//	ServletTool.getInstance().writeCookie(res, Constant.COOKIE_LOGIN_ERROR, "false", 3600);
			req.getSession().setAttribute(Constant.SESSION_LOGIN_ERROR, "false");
			
			return onLoginSuccess(token, subject, request, response);
		} catch (AuthenticationException e) {
		//	ServletTool.getInstance().writeCookie(res, Constant.COOKIE_LOGIN_ERROR, "true", 3600);
			req.getSession().setAttribute(Constant.SESSION_LOGIN_ERROR, "true");
			return onLoginFailure(token, e, request, response);
		}
	}
	

	@Override
	protected CaptchaUsernamePasswordToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		String captcha = getCaptcha(request);
		boolean rememberMe = isRememberMe(request);
		String host = getHost(request);
		return new CaptchaUsernamePasswordToken(username, password, rememberMe, host, captcha);
	}
	
	protected boolean validateCaptcha(HttpServletRequest request, CaptchaUsernamePasswordToken token) {
		boolean flag = true;
		String cookieLoginError ="";// ServletTool.getInstance().readCookie(request, Constant.COOKIE_LOGIN_ERROR);
		if ("true".equals(cookieLoginError) || "true".equals(request.getSession().getAttribute(Constant.SESSION_LOGIN_ERROR))) {
			String captcha = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

			flag = captcha != null && captcha.equalsIgnoreCase(token.getCaptcha());
		}

		return flag;
	}

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}

	@Override
	protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
		request.setAttribute(getFailureKeyAttribute(), ae.getMessage());
	}
}
