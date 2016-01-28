package com.bs.core.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.bs.core.common.Constant;
import com.bs.core.entity.AuthMapping;
import com.bs.core.entity.ButtonGroup;
import com.bs.core.entity.ContextData;
import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.initialize.InitializeData;
import com.bs.core.service.SpringContextUtil;
import com.bs.core.utils.CharacterUtil;


/**
 * Handles requests for service.
 */
 
public abstract class BaseController extends MultiActionController{
	
	public static Logger blogger = Logger.getLogger(BaseController.class);
	public final static String BUTTON_GROUP = "buttonGroup";
	/**重复提交拦截器url（成功能内部转向到此url）*/
	public final static String REPEAT_SUBMIT_COMMON = "/repeat/submit/common";
	/**页面回退统一拦截URL**/
	public final static String HISTORY_BACK_URL = "/history/back/{code}";
	/**重定向前缀L**/
	public final static String REDIRECT = "redirect:";
	/**统一跳转前缀**/
	public final static String GOTO = "/goto";
	/**下载前缀**/
	public final static String DOWNLOAD = "/download";
	/**上传前缀**/
	public final static String UPLOAD = "/upload";
	/**response返回前缀**/
	public final static String PRINT = "/print";
	/**重复提交前缀**/
//	public final static String REDIRECT_TOKEN = "redirect:/repeat/submit/";
	
	/**通用字符串常量**/
	public final static String COMMON = "common";
	/**系统处理状态只有两种成功和失败，且对应success和fail两个视图**/
	public final static String SUCCESS = "success";
	public final static String FAIL = "fail";
	public final static String SPLIT = ",";
	public final static String PATH_SPLIT = "/";
	public final static String STATUS = "status";
	public final static String PROMPT_MESSAGE = "promptMessage";
	public final static String VIEW_NAME = "viewName";
	public final static String SERVICE = "Service";
	public final static String UNIQUE = "unique";
	/**日志记录对象实体bean**/
	public final static String LOG = "log";
	/**日志记录保存方法名称**/
	public final static String SAVE = "save";
	@Resource
	public DelegatingMessageSource messageSource;
	@Resource
	public Validator validator;
	@Autowired
	private InitializeData initializeData;
	
	/**
	 * 处理参数到上文中
	 * @param Enumeration
	 * @param resultData
	 */
	public void setParameters(HttpServletRequest request,ResultData resultData){
		//读取Attribute属性值并将值设置到上文中
//		Enumeration<?> enumerAttribute = request.getAttributeNames();
//		while(enumerAttribute.hasMoreElements()){
//			Object objParam = enumerAttribute.nextElement();
//			if (objParam instanceof String){
//				String paramName = objParam.toString();
//				Object paramValue = request.getAttribute(paramName);
//				//System.out.println(paramName+ "--" + paramValue);
//				if (paramValue != null){
//					resultData.addObject(paramName, paramValue);
//				}
//			}
//		}
		//读取Parameter属性值并将值设置到上文中
		Enumeration<?> enumerParameter = request.getParameterNames();
		while(enumerParameter.hasMoreElements()){
			Object objParam = enumerParameter.nextElement();
			if (objParam instanceof String){
				String paramName = objParam.toString();
				String paramValue = request.getParameter(paramName);
				if (paramValue != null){
					resultData.addObject(paramName, paramValue);
				}
			}
		}
	}
	
	/**
	 * 根据code 获取历史状态数据
	 * @param code
	 * @param request
	 * @return
	 */
	public ContextData getHistoryContextData(String code,HttpServletRequest request){
		//历史回退值必须为1
		if (code != null){
			blogger.debug("==>history context data key is:" + code);
			HttpSession session = request.getSession();
			//读取当时url
			Object obj = session.getAttribute(code);
			if (obj instanceof ContextData ){
				blogger.debug("==>get history context data:" + obj);
				return (ContextData)obj;
			}
		}
		return null;
	}
	
	/**
	 * 根据URL后面传值，随机设置是否记录URL和参数对象信息
	 * @param command
	 * @param request
	 */
	public void addContextData(String code,String model,String method,String viewName,Entity command ,HttpServletRequest request){
		HttpSession session = request.getSession();
		//url传值时显示声明是否记录上下文数据到session中
		String contextCode = command.getIsContextCode();
		//为1的时候，代表设置上下问参数
		if (contextCode != null && contextCode.equals("1")){
			blogger.debug("==>add context data key is:"  + code + " [IsContextCode=1] ");
			ContextData contextData = new ContextData();
			contextData.setUrlPrefix(GOTO);
			contextData.setCode(code);
			contextData.setModel(model);
			contextData.setMethod(method);
			contextData.setCommand(command);
			contextData.setViewName(viewName);
			String requestUrl = request.getRequestURI();
			contextData.setRequestUrl(requestUrl);
			blogger.debug("==>add context data:"  + contextData + " [view-name:" + viewName + "] ");
			//将请求的url与code做映射，存储到session中
			session.setAttribute(requestUrl, code);
			//将上线文 对象存放到session中
			session.setAttribute(code, contextData);
		}
	}
	
	/**
	 * 根据按钮组设置成功页面按钮返回url等信息
	 * @param request
	 * @return
	 */
	public ArrayList<ButtonGroup> getButtonGroup(Entity commond,HttpServletRequest request){
		//获取页面按钮组设置参数
		String buttonGroupSet [] = commond.getButtonGroup();
		if (buttonGroupSet != null && buttonGroupSet.length > 0){
			String buttonGroupAll = buttonGroupSet[0];
			try {
				buttonGroupAll  = URLDecoder.decode(buttonGroupAll,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			String buttonGroupArr[] = buttonGroupAll.split("#");
			ArrayList<ButtonGroup> bglist = new ArrayList<ButtonGroup>();
			for (String code:buttonGroupArr){
				if (code != null){
					String codeValue [] = code.split(",");
					if (codeValue.length == 2){
						ButtonGroup buttonGroup = new ButtonGroup();
						buttonGroup.setViewCode(codeValue[0]);
						buttonGroup.setButtonName(codeValue[1]);
						bglist.add(buttonGroup);
					}
				}
			}
			return bglist;
		}
		else{
			return new ArrayList<ButtonGroup>();
		}
	}
	
	/**
	 * 根据对象模型获取对象类名称（不包括名称，首字母小写）
	 * @param command
	 * @return
	 */
	public String getBinderCommandName(Object command){
		String commandName = command.getClass().getSimpleName();
		commandName = CharacterUtil.toLowerCaseFirstOne(commandName);
		return commandName;
	}
	

	/**
	 * 根绝实体bean名称，拼接对应的service名称
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Object getService(String model){
		String serviceName = model + "Service";
		Object service = SpringContextUtil.getBean(serviceName);
		blogger.debug("==>get spring service:[" + serviceName + "]"  + service);
		return service;
	}
	
	/**
	 * 获取url对应的视图code
	 * @param request
	 * @return
	 */
	public String  getRefererUrlCode(HttpServletRequest request){
    	String referer = request.getHeader("referer");
    	String code = null;
    	//默认通过request referer进行上一个视图返回跳转
    	//也可以自定义
    	if (referer != null){
    		int idx = referer.indexOf("?");
    		if (idx >= 0){
    			referer = referer.substring(0,idx);
    		}
    		referer = referer.replaceAll("http://", "").replaceAll("http://","");
    		int indexSplit = referer.indexOf("/");
    		referer = referer.substring(indexSplit, referer.length());
    		Object objCode = request.getSession().getAttribute(referer);
    		if (objCode != null){
    			return objCode.toString();
    		}
    	}
    	return code;
	}
	
	/**
	 * 获取验证页面的code
	 * @param request
	 * @return
	 */
	public String getSessionViewCode(HttpServletRequest request){
		String requestUrl = request.getRequestURI();
		HttpSession session = request.getSession();
		//以form表单提交的url为key，来存储view code
		Object sobj = session.getAttribute(requestUrl);
		//如果session中不存在view code，从referer中获取，并存储到session中
		if (sobj == null){
			String refererViewCode = getRefererUrlCode(request);
			session.setAttribute(requestUrl, refererViewCode);
			return refererViewCode;
		}
		else{
			//否者直接将session获取的view code返回
			return sobj.toString();
		}
	}
	
	/**
	 * 获取commond 类实例
	 * @param model
	 * @return
	 */
	public Object getCommond(String model){
		Object service = getService(model);
		if(service == null){
			return null;
		}
		Type superClass = service.getClass().getSuperclass().getGenericSuperclass();
		Class<?> type = (Class<?>) ((ParameterizedType) superClass).getActualTypeArguments()[0];
		try {
			Object command = type.newInstance();
			blogger.debug("==>get command entity:[" + command.getClass().getSimpleName() + "]" + command);
			return command;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * request对象数据映射到实体bean
	 * 
	 * @param targetService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ServletRequestDataBinder binder(Object command,HttpServletRequest request){
		String commandName = this.getBinderCommandName(command);
		ServletRequestDataBinder binder = new ServletRequestDataBinder(command,commandName);
        try {
        	blogger.debug("==>binding request to command entity:[" + command.getClass().getSimpleName() + "]"  + command);
			super.initBinder(request,binder);
		} catch (Exception e) {
			e.printStackTrace();
		}
        binder.bind(request);
        return binder;
	}
	
	/**
	 * 获取基类对象
	 * @param command
	 * @return
	 */
	public Entity getEntity(Object command){
		if (command != null){
			String superName = command.getClass().getSuperclass().getSuperclass().getName();
			if (superName.equals(Entity.class.getName())){
				return (Entity)command;
			}
			return (Entity)command;
		}


		blogger.debug("==>command class is null");
		return null;
	}
	
	/**
	 * 通用业务执行调用方法
	 * @param command
	 * @param model
	 * @param method
	 * @param modelMap
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @return
	 */
	public ResultData excute(
			Object command,
			String model, 
			String method,
			ModelMap modelMap,
			BindingResult bindingResult,
			HttpServletRequest request,
			HttpServletResponse response) {
		ResultData resultData = null;
		Object service = getService(model);
		String isLog = "0";
		try {
			//设置通用参数
			Entity baseEntity = getEntity(command);
			baseEntity.setHttpServletRequest(request);
			baseEntity.setHttpServletResponse(response);
			baseEntity.setModelMap(modelMap);
			baseEntity.setBindingResult(bindingResult);
			//设置分页参数只支持mysql
			int start = (baseEntity.getPage() - 1) * baseEntity.getRows();
			int offset = baseEntity.getRows();
			baseEntity.setStart(start);
			baseEntity.setOffset(offset);
			isLog = baseEntity.getIsLog();
			blogger.debug("==>setting base entity paramter!");
			//String className = service.getClass().getName();
			Class<?> c = service.getClass();
			try{
				blogger.debug("==>invoke command service:" + service);
				Method methodTemp = c.getMethod(method, command.getClass());
				resultData = (ResultData) methodTemp.invoke(service, new Object[] {command});
			}
			catch(Exception e){
				blogger.debug("==>invoke command service:" + service);
				Class<?> sc = service.getClass().getSuperclass().getSuperclass();
				Method methodTemp = sc.getMethod(method, command.getClass());
				resultData = (ResultData) methodTemp.invoke(service, new Object[] {command});
			}
			String status = resultData.getStatus();
			if (status == null){
				return resultData;
			}
			if (isLog != null && (isLog.equals("1") || isLog.equals("true"))){
				//记录操作日志
				String logContent = this.getPromptMessage(baseEntity, method, resultData, messageSource, request);
				blogger.debug("==>logging content:" + logContent);
				Object  logEntity = this.getCommond(LOG);
				if (logEntity != null){
					Object logService = getService(LOG);
					Class<?> clog = logService.getClass();
					try{
						if (logEntity != null){
							Entity logBaseEntity = getEntity(logEntity);
							logBaseEntity.setOperation(method);
							logBaseEntity.setAccessIp(request.getRemoteAddr());
							logBaseEntity.setLogContent(logContent);
							logBaseEntity.setIsLog(isLog);
						}
						Method methodTemp = clog.getMethod(SAVE, logEntity.getClass());
						blogger.debug("==>invoke logging service:" + logService);
						methodTemp.invoke(logService, new Object[] {logEntity});
					}
					catch(Exception e){
						Class<?> sc = logService.getClass().getSuperclass().getSuperclass();
						Method methodTemp = sc.getMethod(SAVE, logEntity.getClass());
						blogger.debug("==>invoke logging service:" + logService);
						methodTemp.invoke(logService, new Object[] {logEntity});
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			blogger.error(e.toString());
		}
		return resultData;
	}
	
	
	/**
	 * 获取视图路径
	 * @param initializeData
	 * @param code
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getViewPath(
			InitializeData initializeData,
			String code) {
		String viewPath = null;
		try {
			if(initializeData != null){
				Map<String,Object> mapObj = initializeData.getDatabaseData();
				if (mapObj != null){
					Object obj = mapObj.get(Constant.AUTH_MAPPING);
					if (obj instanceof  HashMap){
						HashMap<String,AuthMapping> authObj = (HashMap<String,AuthMapping>)obj;
						AuthMapping authMapping = authObj.get(code);
						if (authMapping != null){
							viewPath = authMapping.getViewName();
						}
						else{
							return null;
						}
					}
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
			blogger.error(e.toString());
		}
		return viewPath;
	}
	
	/**
	 * 设置获取code的key值在上文,以方便获取跳转url
	 * @param resultData
	 * @param initializeData
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void setAuthCode(ResultData resultData,InitializeData initializeData){
		try {
			if(initializeData != null){
				Map<String,Object> mapObj = initializeData.getDatabaseData();
				if (mapObj != null){
					Object obj = mapObj.get(Constant.AUTH_MAPPING);
					if (obj instanceof  HashMap){
						HashMap<String,AuthMapping> authObj = (HashMap<String,AuthMapping>)obj;
						Iterator<String> iterator = authObj.keySet().iterator();
						while (iterator.hasNext()) {
							String key = iterator.next();
							Object value = authObj.get(key);
							if (value instanceof  AuthMapping){
								AuthMapping authMapping = (AuthMapping)value;
								resultData.addObject(authMapping.getKey()+ "_code", authMapping.getCode());
							}
						}
					}
				}
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
			blogger.error(e.toString());
		}
	}
	
	
	/**
	 * 获取页面提示信息
	 * @param command
	 * @param messageSource
	 * @param request
	 * @return
	 */
	public String getPromptMessage(Entity command,String method,ResultData resultData,DelegatingMessageSource messageSource,HttpServletRequest request) {
		//页面配置隐藏元素的名称（name属性），值为要进行提示信息替换的字段名称
		String replaceMessageElementNames = command.getReplaceName();
		String elementName [] = null;
		//若设置消息替换字段，将该值转换成数组，并从request 中获取对应的值
		//放到参数数组中
		if (replaceMessageElementNames != null){
			String rmen [] = replaceMessageElementNames.split(SPLIT);
			elementName = new String[rmen.length];
			for (int i=0;i<rmen.length;i++){
				String name = rmen[i];
				String paramValue = request.getParameter(name);
				if (paramValue != null){
					elementName[i] = paramValue;
				}
				else{
					elementName[i] = "";
				}
			}
		}
		else{
			elementName = new String[0];
		}
		String commandName =  command.getClass().getSimpleName();
		commandName = CharacterUtil.toLowerCaseFirstOne(commandName);
		//资源文件后缀默认为系统操作状态
		String messageSuffixTemp = resultData.getStatus();
		//提示信息code后缀，只在有异常中使用自定义设置
		//如果有异常且异常为unique约束，则后缀为unique，
		//否者为自定义设置，如果没有自定义，则默认为 fail
		String statusException = resultData.getStatusException();
		if (statusException != null){
			if (statusException.toLowerCase().indexOf("duplicate") > -1 
					|| statusException.toLowerCase().indexOf("unique key") > -1 
					|| statusException.toLowerCase().indexOf("unique constraint") > -1) {
				messageSuffixTemp = UNIQUE;
			}
			else{
				String  messageSuffix = resultData.getMessageSuffix();
				if (messageSuffix != null && !"".equals(messageSuffix)){
					messageSuffixTemp = messageSuffix;
				}
				else{
					messageSuffixTemp = FAIL;
					if (resultData.getStatus() == null){
						resultData.setStatus(FAIL);
					}
				}
			}
		}
		//获取消息code结构，值必须遵循serviceName.method.messageSuffix
		//否者获取不到提示信息
		String code = commandName + SERVICE + "." + method + "." + messageSuffixTemp;
		Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
		String message = messageSource.getMessage(code, elementName, locale);
//		String srcPromptMessage = StringUtils.isNotBlank(resultData.getPromptMessage())? resultData.getPromptMessage():"";
		if(StringUtils.isBlank(resultData.getPromptMessage())) {
			resultData.setPromptMessage(message);
		}
		return resultData.getPromptMessage();
	}
	/**
	 * 根据code 获取错误信息
	 * @param code
	 * @param messageSource
	 * @param request
	 * @return
	 */
	public String getPromptMessageByCode(Entity commond,String code,DelegatingMessageSource messageSource,HttpServletRequest request) {
		//commond 为空 直接返回code 对应的 内容
		if  (commond == null){
			Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
			return messageSource.getMessage(code, null, locale);
		}
		//页面配置隐藏元素的名称（name属性），值为要进行提示信息替换的字段名称
		String replaceMessageElementNames = commond.getReplaceName();
		String elementName [] = null;
		//若设置消息替换字段，将该值转换成数组，并从request 中获取对应的值
		//放到参数数组中
		if (replaceMessageElementNames != null){
			String rmen [] = replaceMessageElementNames.split(SPLIT);
			elementName = new String[rmen.length];
			for (int i=0;i<rmen.length;i++){
				String name = rmen[i];
				String paramValue = request.getParameter(name);
				if (paramValue != null){
					elementName[i] = paramValue;
				}
				else{
					elementName[i] = "";
				}
			}
		}
		else{
			elementName = new String[0];
		}
		Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
		return messageSource.getMessage(code, elementName, locale);
	}
	
	/**
	 * 异步请求时，将验证消息放到返回的map对象中
	 * @param gridMap
	 * @param bindingResult
	 * @param request
	 * @return
	 */
	public Map<String,Object> asyncPromptMessageHandle(
			Entity commond,
			Map<String, Object> modelMap,
			BindingResult bindingResult,
			HttpServletRequest request){
		if (modelMap == null){
			modelMap = new HashMap<String,Object>();
		}
		if (bindingResult.hasErrors()){
        	List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        	for (FieldError fieldError:fieldErrorList){
        		String field = fieldError.getField();
        		String[] codes = fieldError.getCodes();
        		String message = null;
        		for (String code:codes){
        			message += " " + getPromptMessageByCode(commond,code, messageSource, request);
        		}
        		modelMap.put(field, message);
        	}
        }
		return modelMap;
	}
	
	/**
	 * 页面提交操作提示详细处理
	 * @param command
	 * @param bindingResult
	 * @param modelMap
	 * @param request
	 * @return
	 */
	public ResultData validErrorPromptMessageHandle(
			Object command,
			BindingResult bindingResult,
			ModelMap modelMap,
			HttpServletRequest request){
		String commandName = getBinderCommandName(command);
        if (bindingResult.hasErrors()){
        	modelMap.addAttribute(BindingResult.class.getName()+"."+commandName,bindingResult);
        }		
		return null;
	}
	
	/**
	 * 跳转通用方法
	 * @param model
	 * @param method
	 * @param view
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 * @throws Exception 
	 */
	public ResultData gotoModleMethodView(
			String model,
			String method,
			HttpServletRequest request, 
			HttpServletResponse response,
			ModelMap modelMap) throws Exception {
		//实体bean
		Object command = getCommond(model);
		if (command != null){
			//绑定
			ServletRequestDataBinder binder = this.binder(command, request);
			if (modelMap != null){
				modelMap.addAttribute(model,command);
			}
			//调用实体对应的业务类方法
			ResultData resultData = this.excute(command,model,method,modelMap,binder.getBindingResult(),request, response);
			//设置code获取在上文
			this.setAuthCode(resultData, initializeData);
			//String isDebug = this.getDebugStatus(initializeData);
			//resultData.addObject("isDebug", isDebug);
			//如果返回结果的视图名称为空，则设置code对应的视图
			if (resultData.getViewName() == null){
				//获取基类实体
				Entity entity = this.getEntity(command);
				//获取视图编码
				String viewCode = entity.getViewCode();
				//根据code获取视图名称
				String viewName = this.getViewPath(initializeData, viewCode);
				//视图不存在，抛出异常，并不记录上下参数状态
				if (viewName != null && !viewName.equals("")){
					resultData.setViewName(viewName);
					//设置上下文参数
					this.addContextData(viewCode, model, method,viewName, entity, request);
				}
				else{
					throw new Exception("please setting view code!");
				}
			}else {
				//获取基类实体
				Entity entity = this.getEntity(command);
				//获取视图编码
				String viewCode = entity.getViewCode();
				String viewName = resultData.getViewName();
				//视图不存在，抛出异常，并不记录上下参数状态
				if (viewName != null && !viewName.equals("")){
					resultData.setViewName(viewName);
					//设置上下文参数
					this.addContextData(viewCode, model, method,viewName, entity, request);
				}
				else{
					throw new Exception("please setting view code!");
				}
			}
			return resultData;
		}
		else{
			throw new Exception("model is not exist!");
		}
	}
	
	public InitializeData getInitializeData() {
		return initializeData;
	}

	public void setInitializeData(InitializeData initializeData) {
		this.initializeData = initializeData;
	}
	
	
}
