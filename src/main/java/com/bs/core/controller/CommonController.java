package com.bs.core.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.pc.productattributeconfig.entity.ProductAttributeConfig;
import com.bs.plugins.custom.uc.user.entity.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.bs.core.entity.ButtonGroup;
import com.bs.core.entity.ContextData;
import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;

/**
 * Handles requests for service.
 */

@Controller
public class CommonController extends BaseController {
	
	public static Logger logger = Logger.getLogger(CommonController.class);
	/**
	 * 默认根目录（webroot）拦截器
	 * @param request
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView root( HttpServletRequest request) {
		ResultData resultData = new ResultData();
		resultData.setViewName("redirect:/login");
		return resultData;
	}	
	
	/**
	 * 首页处理拦截器，跳转到登录页
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index( HttpServletRequest request) {
		ResultData resultData = new ResultData();
		resultData.setViewName("redirect:/login");
		return resultData;
	}
	
	/**
	 * 登录页拦截器
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login( HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null){
			subject.logout();
		}
		ResultData resultData = new ResultData();
		resultData.setViewName("login");
		return resultData;
	}
	
	/**
	 * 主窗体页面拦截器
	 * @param request
	 * @return
	 */
	@RequestMapping("/main")
	public ModelAndView main( HttpServletRequest request) {
		ResultData resultData = new ResultData();
		resultData.setViewName("main");
		return resultData;
	}
	
	@RequestMapping("/right")
	public ModelAndView right( HttpServletRequest request) {
		ResultData resultData = new ResultData();
		resultData.setViewName("right");
		return resultData;
	}
	
	@RequestMapping("/register")
	public ModelAndView register( HttpServletRequest request) {
		ResultData resultData = new ResultData();
		resultData.setViewName("register");
		return resultData;
	}
	
	@RequestMapping("/home")
	public ModelAndView home( HttpServletRequest request) {
		ResultData resultData = new ResultData();
		resultData.setViewName("home");
		return resultData;
	}
	
	/**
	 * 退出页面拦截器
	 * @param request
	 * @return
	 */
	@RequestMapping("/exit")
	public ModelAndView exit( HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null){
			subject.logout();
		}
		ResultData resultData = new ResultData();
		resultData.setViewName("exit");
		return resultData;
	}
	
	/**
	 * 无成功提示页，防止重复提交页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = REPEAT_SUBMIT_COMMON, method = RequestMethod.GET)
	public ModelAndView repeatSubmitCommon(
			Entity entity,
			ModelMap modelMap,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ResultData resultData= new ResultData();
		String view = entity.getViewName();
		if (view == null){
			view = FAIL;
		}
		//设置成功页面按钮信息
		ArrayList<ButtonGroup> bglist = getButtonGroup(entity,request);
		String promptMessage = entity.getPromptMessage();
		try {
			promptMessage  = URLDecoder.decode(promptMessage,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		resultData.addObject(PROMPT_MESSAGE, promptMessage);
		resultData.addObject(BUTTON_GROUP, bglist);
		resultData.setViewName(view);
		return resultData;
	}
	
	@RequestMapping(value = HISTORY_BACK_URL, method = RequestMethod.GET)
	public ModelAndView historyBackUrl(
			@PathVariable String code,
			HttpServletRequest request, 
			HttpServletResponse response,
			ModelMap modelMap) {
		ContextData contextData = super.getHistoryContextData(code, request);
		if (contextData != null){
			String model = contextData.getModel();
			String method = contextData.getMethod();
			Object command = contextData.getCommand();
			String viewName = contextData.getViewName();
			String commandName = this.getBinderCommandName(command);
			modelMap.addAttribute(commandName, command);
			ResultData resultData = this.excute(command, model, method, modelMap, null, request, response);
			resultData.setViewName(viewName);
//			modelMap.addAttribute(commandName,command);
			//设置code获取在上文
			this.setAuthCode(resultData, super.getInitializeData());
			return resultData;
		}
		else{
			ResultData resultData = new ResultData();
			String promptMessage = getPromptMessageByCode(null,"system.prompt.error", messageSource, request);
			resultData.addObject(PROMPT_MESSAGE,promptMessage);
			resultData.setViewName(FAIL);
			return resultData;
		}
	}
	
	/**
	 * 指定视图的提交跳转
	 * @param model
	 * @param method
	 * @param code
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value ="/form/submit/{model}/{method}", method = RequestMethod.POST)
	public ModelAndView formSubmit(
			@PathVariable String model,
			@PathVariable String method, 
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap modelMap) {
		ResultData resultData = null;
		Object command = this.getCommond(model);
		if (command != null){
			ServletRequestDataBinder binder = this.binder(command, request);
			//转换成基类对象，获取或设置全局参数
			Entity entity = super.getEntity(command);
			if(entity.getOpId() == null) {
				User user = (User) SecurityUtils.getSubject().getPrincipal();
				if(user != null && user.getId() != null) {
					entity.setOpId(user.getId());
				}else {
					entity.setOpId(0L);
				}
			}
			//页面表单是否验证
			String isFormValid = entity.getIsFormValid() == null ?"1":entity.getIsFormValid();
			
			BindingResult bindingResult = null;
			//获取view code
			String viewCode = super.getSessionViewCode(request);
			if (viewCode == null || viewCode.equals("")){
				viewCode = entity.getViewCode();
			}
			if (!isFormValid.equals("0")){
				if (viewCode != null){
			        BindException errors = new BindException(binder.getBindingResult());
			        validator.validate(command, errors);
			        bindingResult = binder.getBindingResult();
			        if (bindingResult != null && bindingResult.hasErrors()){
						String commandName = getBinderCommandName(command);
			            if (bindingResult.hasErrors()){
			            	modelMap.addAttribute(BindingResult.class.getName() + "." + commandName,bindingResult);
			            }
			            //验证为通过不记录日志
			            entity.setIsLog("0");
			            resultData = invokeHistoryContext(command,viewCode,request,response,bindingResult,modelMap);
			            resultData.addObject(commandName, command);
			            modelMap.addAttribute(commandName, command);
			            //设置code获取在上文
						this.setAuthCode(resultData, super.getInitializeData());
			            return resultData;
			        }
				}
				else{
					logger.debug("==>valid fail: view code is null.");
				}
			}
	        //调用service 方法
			resultData = this.excute(command,model,method,modelMap,bindingResult,request, response);
			if (!isFormValid.equals("0")){
				if (viewCode != null){
					//执行service 方法后手动设置错误提示信息
		        	if (resultData != null){
						//返回结果有验证错误，自定义验证
				        BindingResult bindingResultTemp = resultData.getBindingResult();
				        if (bindingResultTemp != null && bindingResultTemp.hasErrors()){
					        if (bindingResultTemp != null){
				        		String commandName = getBinderCommandName(command);
				        		if (bindingResult != null && bindingResult.hasErrors()){
					            	modelMap.addAttribute(BindingResult.class.getName() + "." + commandName,bindingResult);
					            }

								Object origCommand = null;
								try {//注意：该处必须要invokeHistoryContext（）前执行，否则至变化
									origCommand = BeanUtils.cloneBean(command);
								} catch (IllegalAccessException e) {
									e.printStackTrace();
								} catch (InstantiationException e) {
									e.printStackTrace();
								} catch (InvocationTargetException e) {
									e.printStackTrace();
								} catch (NoSuchMethodException e) {
									e.printStackTrace();
								}
								//验证为通过不记录日志
					            entity.setIsLog("0");
				        		resultData = invokeHistoryContext(command,viewCode,request,response,bindingResult,modelMap);
								if("product".equals(commandName)) {
									Product targetProduct = (Product)origCommand;
									Product oldProduct = (Product)resultData.getModelMap().get("product");
									command = mergeEntityInfo(targetProduct,oldProduct);
								}
				        		modelMap.addAttribute(commandName, command);
				        		resultData.addAllObjects(modelMap);
								resultData.addObject(commandName, command);

				        		//设置code获取在上文
								this.setAuthCode(resultData, super.getInitializeData());
								return resultData;
					        }
				        }
		        	}
				}
				else{
					logger.debug("==>valid fail: view code is null.");
				}
			}
			String buttonGroup [] = entity.getButtonGroup();
			if (buttonGroup != null){
				String bgs = null;
				for (String bg:buttonGroup){
					if (bgs == null){
						bgs = bg;
					}
					else{
						bgs += "#" + bg;
					}
				}
				try {
					bgs = java.net.URLEncoder.encode(bgs,"UTF-8");
					resultData.addObject(BUTTON_GROUP,bgs);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (resultData != null){
				//视图名称
				resultData.addObject(VIEW_NAME,resultData.getStatus());
				//读取页面提示信息
				String promptMessage = getPromptMessage(entity,method,resultData,messageSource,request);
				try {
					promptMessage = java.net.URLEncoder.encode(promptMessage,"UTF-8");
					resultData.addObject(PROMPT_MESSAGE,promptMessage);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				//redirect进行转向，防止重复提交
				resultData.setViewName(REDIRECT + REPEAT_SUBMIT_COMMON);
			}
			else{
				resultData = new ResultData();
				String promptMessage = getPromptMessageByCode(entity,"system.prompt.error", messageSource, request);
				resultData.setPromptMessage(promptMessage + "[ResultData is null error]");
				try {
					promptMessage = java.net.URLEncoder.encode(promptMessage,"UTF-8");
					resultData.addObject(PROMPT_MESSAGE,promptMessage);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				//redirect进行转向，防止重复提交
				resultData.setViewName(REDIRECT + REPEAT_SUBMIT_COMMON);
			}
		}
		return resultData;
	}

	private Product mergeEntityInfo(Product targetProduct, Product oldProduct) {

		ArrayList<ProductAttributeConfig> targetProductAttributeConfigs = targetProduct.getProductAttributeConfigs();
		ArrayList<ProductAttributeConfig> oldProductAttributeConfigs1 = oldProduct.getProductAttributeConfigs();

		for (ProductAttributeConfig targetProductAttributeConfig : targetProductAttributeConfigs) {
			for (ProductAttributeConfig oldProductAttributeConfig : oldProductAttributeConfigs1) {
				if(targetProductAttributeConfig.getAttributeId().equals(oldProductAttributeConfig.getAttributeId())) {
					targetProductAttributeConfig.setAttribute(oldProductAttributeConfig.getAttribute());
					targetProductAttributeConfig.setStructureConfig(oldProductAttributeConfig.getStructureConfig());
					targetProductAttributeConfig.setOptions(oldProductAttributeConfig.getOptions());
				}
			}
			if(targetProductAttributeConfig.getAttributeValue() != null) {
				targetProductAttributeConfig.setAttributeValue(StringEscapeUtils.unescapeHtml(targetProductAttributeConfig.getAttributeValue().replaceAll("& ", "&")));
			}
		}

		try {
			BeanUtils.copyProperties(oldProduct,targetProduct);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return oldProduct;
	}

	/**
	 * 调用历史上下文数据 进行页面验证跳转
	 * @param code
	 * @param request
	 * @param response
	 * @param bindingResult
	 * @param modelMap
	 * @return
	 */
	public ResultData invokeHistoryContext(
			Object command,
			String code,
			HttpServletRequest request,
			HttpServletResponse response,
			BindingResult bindingResult,
			ModelMap modelMap){
		ContextData contextData = this.getHistoryContextData(code, request);
		if (contextData != null){
			String model = contextData.getModel();
			String method = contextData.getMethod();
			String viewName = contextData.getViewName();
			ResultData resultData = this.excute(command, model, method, modelMap, bindingResult, request, response);
			resultData.setViewName(viewName);
			return resultData;
		}
		return null;
	}
	
	/**
	 * 异步获取数据拦截器
	 * @param model
	 * @param method
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/ajax/getdata/{model}/{method}"/*, method = RequestMethod.POST*/)
	public Map<String, Object> getJson(
			@PathVariable String model,
			@PathVariable String method,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap modelMap) {
		Object command = this.getCommond(model);
		this.binder(command, request);
		ResultData resultData = this.excute(command,model,method ,modelMap,null,request, response);
		Map<String, Object> gridMap = resultData.getResultMap();
		if (gridMap == null){
			gridMap = new HashMap<String,Object>();
		}
		return gridMap;
	}


	
	/**
	 * 异步提交数据拦截器
	 * @param model
	 * @param method
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/ajax/submit/{model}/{method}", method = RequestMethod.POST)
	public Map<String, Object> asyncSubmit(
			@PathVariable String model,
			@PathVariable String method, 
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap modelMap) {
		Map<String, Object> resultMap = null;
		Object command = this.getCommond(model);
		if (command != null){
			this.binder(command, request);
			Entity entity = super.getEntity(command);
			if(entity.getOpId() == null) {
				User user = (User) SecurityUtils.getSubject().getPrincipal();
				if(user != null && user.getId() != null) {
					entity.setOpId(user.getId());
				}else {
					entity.setOpId(0L);
				}
			}
	        ResultData resultData = this.excute(command,model,method,modelMap,null,request, response);
	        if (resultData != null){
	        	resultMap = resultData.getResultMap();
	        	if (resultMap == null){
	        		resultMap = new HashMap<String,Object>();
	        	}
	        	//读取页面提示信息
				String promptMessage = getPromptMessage(entity,method,resultData,messageSource,request);
				resultMap.put(PROMPT_MESSAGE,promptMessage);
				resultMap.put(STATUS, resultData.getStatus());
	        }
	        else{
	        	resultMap = new HashMap<String,Object>();
				String message = getPromptMessageByCode(entity,"system.prompt.error", messageSource, request);
				resultMap.put(PROMPT_MESSAGE, message + "[ResultData is null error]");
				resultMap.put(STATUS, FAIL);
			}
		}
		return resultMap;
	}
	/**
	 * 异步验证提交
	 * @param model
	 * @param method
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value ="/ajax/submit/valid/{model}/{method}", method = RequestMethod.POST)
	public Map<String, Object> asyncValidSubmit(
			@PathVariable String model,
			@PathVariable String method, 
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap modelMap) {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		Object command = this.getCommond(model);
		if (command != null){
			ServletRequestDataBinder binder = this.binder(command, request);
	        BindException errors = new BindException(binder.getBindingResult());
	        validator.validate(command, errors);
	        BindingResult bindingResult = binder.getBindingResult();
	        Entity entity = super.getEntity(command);
	        resultMap = asyncPromptMessageHandle(entity,resultMap,bindingResult,request);
	        if (!resultMap.isEmpty()){
	        	return resultMap;
	        }
	        ResultData resultData = this.excute(command,model,method,modelMap,bindingResult,request, response);
	        if (resultData != null){
	        	//返回结果有验证错误，自定义验证
		        BindingResult bindingResultTemp = resultData.getBindingResult();
		        if (bindingResultTemp != null){
		        	resultMap = asyncPromptMessageHandle(entity,resultMap,bindingResultTemp,request);
			        if (!resultMap.isEmpty()){
			        	return resultMap;
			        }
		        }
	        	resultMap = resultData.getResultMap();
	        	resultMap = asyncPromptMessageHandle(entity,resultMap,bindingResult,request);
	        	//读取页面提示信息
				String promptMessage = getPromptMessage(entity,method,resultData,messageSource,request);
				resultMap.put(PROMPT_MESSAGE,promptMessage);
				resultMap.put(STATUS, resultData.getStatus());
	        }
	        else{
				String message = getPromptMessageByCode(entity,"system.prompt.error", messageSource, request);
				resultMap.put(STATUS,FAIL);
				resultMap.put(PROMPT_MESSAGE, message + "[ResultData is null error]");
			}
		}		
		return resultMap;
	}

	/**
	 * 页面跳转对应URL拦截
	 * view：代表视图名称（对应的页面展示文件）
	 * model：代表模型名称，同时对应业务处理的service名称，model+“Service” method：业务处理方法名称
	 * @param model
	 * @param method
	 * @param view
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = GOTO + "/{model}/{method}", method = RequestMethod.GET)
	public ResultData gotoModleMethodView(
			@PathVariable String model,
			@PathVariable String method,
			HttpServletRequest request, 
			HttpServletResponse response,
			ModelMap modelMap) {
		try {
			return super.gotoModleMethodView(model, method, request, response, modelMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 页面直接response输出
	 * @param model
	 * @param method
	 * @param request
	 * @param response
	 * @param modelMap
	 */
	@RequestMapping(value = PRINT + "/{model}/{method}", method = RequestMethod.GET)
	public void print(
			@PathVariable String model,
			@PathVariable String method,
			HttpServletRequest request, 
			HttpServletResponse response,
			ModelMap modelMap) {
		String resultStringData = "";
		try {
			Object command = this.getCommond(model);
			if (command != null){
				this.binder(command, request);
		        ResultData resultData = this.excute(command,model,method,modelMap,null,request, response);
		        resultStringData = resultData.getResultString();
			}
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(resultStringData);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 下载
	 * @param model
	 * @param method
	 * @param request
	 * @param response
	 * @param modelMap
	 */
	@RequestMapping(value = DOWNLOAD + "/{model}/{method}", method = RequestMethod.GET)
	public String download(
			@PathVariable String model,
			@PathVariable String method,
			HttpServletRequest request, 
			HttpServletResponse response,
			ModelMap modelMap) {
		Object command = this.getCommond(model);
		if (command != null){
			this.binder(command, request);
	        ResultData resultData = this.excute(command,model,method,modelMap,null,request, response);
	        String fileName = resultData.getDownloadFileName();
	        String filePath = resultData.getDownloadFilePath();
	        response.setContentType("multipart/form-data");
	        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
	        try {
	        	filePath  = filePath + File.separator + fileName;
	            InputStream inputStream = new FileInputStream(new File(filePath));
	            OutputStream outputStream = response.getOutputStream();
	            byte[] b = new byte[2048];
	            int length;
	            while ((length = inputStream.read(b)) > 0) {
	            	outputStream.write(b, 0, length);
	            }
	            outputStream.close();
	            inputStream.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		return null;
	}
	
	/**
	 * 下载
	 * @param model
	 * @param method
	 * @param request
	 * @param response
	 * @param modelMap
	 */
	@RequestMapping(value = UPLOAD + "/{model}/{method}", method = RequestMethod.GET)
	public Map<String,Object> upload(
			@PathVariable String model,
			@PathVariable String method,
			HttpServletRequest request, 
			HttpServletResponse response,
			ModelMap modelMap) {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		try {
			Object command = this.getCommond(model);
			if (command != null){
				this.binder(command, request);
		        ResultData resultData = this.excute(command,model,method,modelMap,null,request, response);
		        String filePath = resultData.getDownloadFilePath();
		        String fileName = resultData.getDownloadFileName();
		        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		        if (multipartResolver.isMultipart(request)) {
		            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		            Iterator<String> iter = multiRequest.getFileNames();
		            while (iter.hasNext()) {
		                MultipartFile file = multiRequest.getFile((String)iter.next());
		                if (file != null) {
		                    String fileNameTemp = file.getOriginalFilename();
		                    if (fileName == null || fileName.equals("")){
		                    	fileName = fileNameTemp;
		                    }
		                    filePath += fileName;
		                    File localFile = new File(filePath);
							file.transferTo(localFile);
		                }
		            }
		        }
		        //读取页面提示信息
				resultMap.put(STATUS, "1");
			}
		} catch (Exception e) {
			//读取页面提示信息
			resultMap.put(STATUS, "0");
			e.printStackTrace();
		}
		return resultMap;
	}

}
