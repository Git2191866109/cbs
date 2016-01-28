package com.bs.core.security;

import org.apache.shiro.authc.UsernamePasswordToken;
 
/**
 * 支持验证码的Token
 * 
 * @author Yuegz
 * 
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 7215554478831572165L;
	/**
	 * The captcha
	 */
	private String captcha;

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public CaptchaUsernamePasswordToken() {
		super();
	}

	public CaptchaUsernamePasswordToken(String username, char[] password, boolean rememberMe, String host, String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}

	public CaptchaUsernamePasswordToken(String username, char[] password, boolean rememberMe, String captcha) {
		super(username, password, rememberMe);
		this.captcha = captcha;
	}

	public CaptchaUsernamePasswordToken(String username, char[] password, String host, String captcha) {
		super(username, password, host);
		this.captcha = captcha;
	}

	public CaptchaUsernamePasswordToken(String username, char[] password, String captcha) {
		super(username, password);
		this.captcha = captcha;
	}

	public CaptchaUsernamePasswordToken(String username, String password, boolean rememberMe, String host, String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}

	public CaptchaUsernamePasswordToken(String username, String password, boolean rememberMe, String captcha) {
		super(username, password, rememberMe);
		this.captcha = captcha;
	}

	public CaptchaUsernamePasswordToken(String username, String password, String host, String captcha) {
		super(username, password, host);
		this.captcha = captcha;
	}

	public CaptchaUsernamePasswordToken(String username, String password, String captcha) {
		super(username, password);
		this.captcha = captcha;
	}
}
