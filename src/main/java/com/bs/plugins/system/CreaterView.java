package com.bs.plugins.system;

import com.bs.plugins.system.service.CreaterViewService;



public class CreaterView{
	
	/**
	 * 生成器主函数
	 * @param arg
	 */
	
	
	public static void main(String[] args) {
		try {
			CreaterViewService createrViewService = new CreaterViewService();
			createrViewService.createViewConfigFile("maven");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 