package com.bs.plugins.thirdparty.umpay;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 解析Html字符串
 */
public class HtmlParseUtil {
	public static Map<String,String> xmlToMap(String html,String messageName){
		
		Map<String,String> resultMap = null;
        try {
        	Parser parser = Parser.createParser(html, "utf-8");  
        	AndFilter filter = new AndFilter(new TagNameFilter("META"),new HasAttributeFilter("name", messageName));  
        	NodeList nodeList = parser.extractAllNodesThatMatch(filter);  
        	//解析出来报文内容
        	String content = null;
        	NodeIterator iterator = nodeList.elements();
        	while (iterator.hasMoreNodes()){
        		Node node = iterator.nextNode(); 
        		TagNode tagNode = new TagNode();
        		tagNode.setText(node.toHtml());
        		content = tagNode.getAttribute("content");
        		break;
        	}
            if (content != null){
            	resultMap = new HashMap<String,String>();
            	String resultsArr [] = content.split("&");
            	for (String result:resultsArr){
            		int index = result.indexOf("=");
            		if (index > 0){
            			String key = result.substring(0,index);
            			String value = result.substring(index + 1,result.length());
            			String keyTemp = null;
            			if (!key.equals("")){
            				//key值转换
            				String keysArr [] = key.split("_");
            				for (int i=0;i<keysArr.length;i++){
            					if (i == 0){
            						keyTemp = keysArr[i];
            					}
            					else{
            						//首字符大写
            						String first = keysArr[i].substring(0, 1).toUpperCase();
            						String rest = keysArr[i].substring(1, keysArr[i].length());
            						keyTemp = keyTemp + (first + rest);
            					}
            				}
            			}
            			resultMap.put(keyTemp, value);
            		}
            	}
            }
            return resultMap;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }
	
	
	public static void main(String arg[]){
		String xml = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">"
+"<html>"
+"<head>"
+"<META NAME=\"MobilePayPlatform\" CONTENT=\"mer_date=20140918&mer_id=7000998&order_id=2014091801&ret_code=0000&sign_type=RSA&version=1.0&sign=bGPoKyfr/Q65/VmAMtYfeBb0fY/Yss1thr/PC8dr23AeLxhm7B8sHQn9E3Ufp9NYl6I6nW4lKgy/sm+C/TuxF5pQLoFDfBuVgpVl0bzqyFwqZHJzWVBxKzHsnpPmGyRgbKyRXGGgRzRZ31Kp2sj0Yx76p8g7Qh9WCRwTvbUkmFs=\" />"
+"</head>"
+"<body>"
+"</body>"
+"</html>";
		HtmlParseUtil.xmlToMap(xml, "MobilePayPlatform");
	}
}
