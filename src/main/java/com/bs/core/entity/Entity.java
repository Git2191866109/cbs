package com.bs.core.entity;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;



public class Entity implements Serializable {
	
	private static final long serialVersionUID = 5574468630643899188L;
	
	/**主键id**/
	private Long id;
	/**权限代码**/
	private String c;
	/**数据访问角色ID**/
	private String roleIds;
	/**排序字段**/
	//private String sort;
	/**数据更改后返回更改数据唯一标识串 */
	private Long generatedKey;
	/**表示请求页码（当前页）的参数名称 */
	private int page;
	/**表示请求记录数的参数名称 */
	private int rows;
	/**表示分页起始数的参数名称 **/
	private int start;
	/**表示分页偏移量 **/
	private int offset;
	/**创建时间**/
	private String createTime;
	/**修改时间**/
	private String modifyTime;
	/**Request对象**/
	private HttpServletRequest httpServletRequest;
	/**Response对象 **/
	private HttpServletResponse httpServletResponse;
	/**Model对象  **/
	private ModelMap modelMap;
	/**Binding对象  **/
	private BindingResult bindingResult;
	/**操作类型 ：create,modify,delete,other**/
	private String operation;
	/**用户访问IP地址  **/
	private String accessIp;
	/**操作日志内容  **/
	private String logContent;
	/**是否记录日志  **/
	private String isLog;
	/**本地文件替换字段声明  **/
	private String replaceName;
	/**是否成功失败提示页面返回  **/
	private String isHistoryBack;
	/**是否记录上下文状态信息  **/
	private String isContextCode;
	/**是否进行表单验证  **/
	private String isFormValid;
	/**成功提示页面按钮组设置  **/
	private String buttonGroup [];
	/**视图对应的code **/
	private String viewCode;
	/**视图对应的code **/
	private String viewName;
	/**提示信息 **/
	private String promptMessage;
	/**操作员ID**/
	private Long opId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public Long getGeneratedKey() {
		return generatedKey;
	}
	public void setGeneratedKey(Long generatedKey) {
		this.generatedKey = generatedKey;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}
	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}
	public HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}
	public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}
//	public String getSort() {
//		return sort;
//	}
//	public void setSort(String sort) {
//		this.sort = sort;
//	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public ModelMap getModelMap() {
		return modelMap;
	}
	public void setModelMap(ModelMap modelMap) {
		this.modelMap = modelMap;
	}
	public BindingResult getBindingResult() {
		return bindingResult;
	}
	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getAccessIp() {
		return accessIp;
	}
	public void setAccessIp(String accessIp) {
		this.accessIp = accessIp;
	}
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	public String getIsLog() {
		return isLog;
	}
	public void setIsLog(String isLog) {
		this.isLog = isLog;
	}
	public String getReplaceName() {
		return replaceName;
	}
	public void setReplaceName(String replaceName) {
		this.replaceName = replaceName;
	}
	public String getIsHistoryBack() {
		return isHistoryBack;
	}
	public void setIsHistoryBack(String isHistoryBack) {
		this.isHistoryBack = isHistoryBack;
	}
	public String getIsContextCode() {
		return isContextCode;
	}
	public void setIsContextCode(String isContextCode) {
		this.isContextCode = isContextCode;
	}
	public String getViewCode() {
		return viewCode;
	}
	public void setViewCode(String viewCode) {
		this.viewCode = viewCode;
	}
	public String getIsFormValid() {
		return isFormValid;
	}
	public void setIsFormValid(String isFormValid) {
		this.isFormValid = isFormValid;
	}
	public String[] getButtonGroup() {
		return buttonGroup;
	}
	public void setButtonGroup(String[] buttonGroup) {
		this.buttonGroup = buttonGroup;
	}
	public String getPromptMessage() {
		return promptMessage;
	}
	public void setPromptMessage(String promptMessage) {
		this.promptMessage = promptMessage;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public Long getOpId() {
		return opId;
	}

	public void setOpId(Long opId) {
		this.opId = opId;
	}
}
