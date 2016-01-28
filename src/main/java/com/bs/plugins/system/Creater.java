package com.bs.plugins.system;

import com.bs.plugins.system.entity.Pdm;
import com.bs.plugins.system.service.CreateDatabaseService;
import com.bs.plugins.system.service.CreaterClassService;
import com.bs.plugins.system.service.ParserPdmService;



public class Creater{
	
	/**
	 * 生成器主函数
	 * @param arg
	 */
	
	
	public static void main(String[] args) {
		try {
			Pdm pdm = new ParserPdmService().pdmParser("C:/work/workspace/xfb_design/Database/mysql-nfw-1.2.pdm");
			CreateDatabaseService createDatabaseService = new CreateDatabaseService();
			createDatabaseService.createDatebase(pdm);
			CreaterClassService createrClassService = new CreaterClassService();
			createrClassService.createTemplate(pdm,"maven");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 