package com.bs.core.common;

public class Constant {
	/**编码**/
	public static final String ENCODING = "UTF-8";
	/** 系统目录 */
	public static final String BASE = "base";
	/** session中使用的key **/
	public static final String SESSION_LOGIN_ERROR = "session_login_error";// 是否启用验证码
 
	/** request中使用的key **/
	public static final String REQ_ENABLE_KAPTCHA = "req_enable_kaptcha";// 是否启用验证码

	/** cookie中使用的key **/
	public static final String COOKIE_LOGIN_ERROR = "cookie_login_error";// 是否登录失败
	/**视图名称**/
	public static String AUTH_MAPPING = "auth_mapping";
	public static String DATASOURCE_MYSQL = "mysql";
	public static String DATASOURCE_ORACLE = "oracle";
	public static String DATASOURCE_SQLSERVER = "sqlserver";
	public static String DATASOURCE_DB2 = "db2";
	public static String DATASOURCE_SYBASE = "sybase";
	public static String DATASOURCE_INFORMIX = "informix";
	public static String DATASOURCE_POSTGRES = "postgres";
	public static String DATASOURCE_MONGODB = "mongo";
	/** 使用数据库类型 */
	public static String DEFAULT_DATABASE_TYPE;
}
 