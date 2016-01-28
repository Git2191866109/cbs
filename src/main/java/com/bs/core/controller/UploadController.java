
package com.bs.core.controller;

import com.baidu.ueditor.ConfigManager;
import com.baidu.ueditor.define.State;
import com.baidu.ueditor.upload.Uploader;
import com.bs.core.initialize.InitializeData;
import com.bs.core.service.CommonService;
import com.bs.core.utils.DateUtil;
import com.bs.plugins.custom.cc.member.entity.Member;
import com.bs.plugins.custom.cc.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.*;
import java.util.*;

@Controller
public class UploadController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private CommonService commonService;

	/**
	 * 文件上传
	 * @param request
	 * @param response
	 * @param
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("/upload")
    public Object uploadFile(HttpServletRequest request,HttpServletResponse response) throws Exception {  
		InitializeData initializeData = commonService.getInitializeData();
		Map<String,String> absPath = initializeData.getPicUploadUrl();
		String memberId ="111";// commonService.getCurrentMemberInfo("id", request);
		if(memberId != null && !"".equals(memberId)){
			String year = DateUtil.getYear(new Date());
			String month = DateUtil.getMonth(new Date());
			String day = DateUtil.getDay(new Date());
			String abspath = absPath.get("picUrl");// 绝对路径
			String relpath =  "/avatar" 
					+ File.separator 
					+ year + File.separator 
					+ month +  File.separator 
					+ day +  File.separator 
					+ memberId + File.separator;
			String finalPath = relpath;
			// 文件名为 UUID
			String fileName = UUID.randomUUID().toString();
			State result = upload(request,abspath, finalPath, fileName);
			return result.toJSONString();
		}else {
			Map<String, String> map = new HashMap<String,String>();
			map.put("message", "paramError");
			return map;
		}
    }  
	
	

	
	 /**
     * 截图
     * @param request
     * @param response
     * @param
	 * @throws Exception 
     */
	@ResponseBody
	@RequestMapping("/redraw") 
    public Object redraw(HttpServletRequest request,HttpServletResponse response) throws Exception {  
		Map<String,String> map = new HashMap<String,String>();
		Member member = new Member();
		try{
			InitializeData initializeData = commonService.getInitializeData();
			Map<String,String> absPath = initializeData.getPicUploadUrl();
			String memberId ="111";// commonService.getCurrentMemberInfo("id", request);
			if(memberId != null && !"".equals(memberId)){
				int x =(int) Double.parseDouble(request.getParameter("x"));  
				int y =(int) Double.parseDouble(request.getParameter("y"));  
				int destWidth =(int) Double.parseDouble(request.getParameter("w"));  
				int destHeight =(int) Double.parseDouble(request.getParameter("h"));  
				Long l = Long.parseLong(memberId);
				member.setId(l);
				member = memberService.getMemberDao().selectOneById(member);
				String relativePath = member.getAvatar();
				String abspath = absPath.get("picUrl");// 绝对路径
				
				String finalPath = abspath + relativePath;
				abscut(finalPath, finalPath, x, y, destWidth, destHeight);
			}	
		}catch(Exception e){
			map.put("message", "error");
			return map;
		}
		map.put("message", "success");
		map.put("picUrl", member.getAvatar());
		return map;
    }
	
	
	/**
	 * 
	 * @param
	 * @param request
	 * @param abspath
	 *@param path 上传路径
	 * @param fileName 文件名   @return 上传结果
	 */
	public State upload(HttpServletRequest request, String rootPath, String contextPath, String fileName) {
		//创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		//判断 request 是否有文件上传,即多部分请求
		if(multipartResolver.isMultipart(request)){
			ConfigManager configManager = ConfigManager.getInstance(rootPath, "", "/ue/config.json");
			Map conf = configManager.getConfig(1);
//			contextPath + "/" + fileName
			return  (new Uploader(request, conf)).doExec();
		}

		return null;
	}
	
	
	/**
	 * 下载文件
	 * @param request
	 * @param response
	 * @param path
	 * @param
	 * @param
	 * @return
	 */
    public Object download(HttpServletRequest request,HttpServletResponse response, String path) {
        try {
	    	File file = new File(path);
	        InputStream inputStream = new FileInputStream(file);
	        OutputStream os = response.getOutputStream();
	        byte[] b = new byte[2048];
	        int length;
	        while ((length = inputStream.read(b)) > 0) {
	            os.write(b, 0, length);
	        }
	        os.close();// 关闭流
	        inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  返回值要注意，要不然就出现下面这句错误
        //getOutputStream() has already been called for this response
        return null;
    }
	

    
    /**  
     * 图像切割     *  
     * @param srcImageFile            源图像地址 
     * @param dirImageFile            新图像地址 
     * @param x                       目标切片起点x坐标 
     * @param y                      目标切片起点y坐标 
     * @param destWidth              目标切片宽度 
     * @param destHeight             目标切片高度 
     */  
    public void abscut(String srcImageFile,String dirImageFile,int x,int y,int destWidth,int destHeight) {  
        try {  
            Image img;  
            ImageFilter cropFilter;  
            // 读取源图像  
            BufferedImage bi = ImageIO.read(new File(srcImageFile));  
            int srcWidth = bi.getWidth(); 
            int srcHeight = bi.getHeight(); 
            if (srcWidth >= destWidth && srcHeight >= destHeight) {  
                Image image = bi.getScaledInstance(srcWidth, srcHeight,Image.SCALE_DEFAULT);  
                cropFilter = new CropImageFilter(x, y, destWidth, destHeight);  
                img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));  
                BufferedImage tag = new BufferedImage(destWidth, destHeight,BufferedImage.TYPE_INT_RGB);  
                Graphics g = tag.getGraphics();  
                // 绘制缩小图  
                g.drawImage(img, 0, 0, null); 
                g.dispose();  
                // 输出为文件  
                ImageIO.write(tag, "JPEG", new File(dirImageFile));  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    
   
}