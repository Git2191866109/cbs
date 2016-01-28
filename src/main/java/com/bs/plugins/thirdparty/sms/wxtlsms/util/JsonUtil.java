package com.bs.plugins.thirdparty.sms.wxtlsms.util;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Json util类
 * 
 * @author Timothy
 */
public class JsonUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * 将Map<String, Object>转成Json串
	 * 
	 * @param map
	 *            Map<String, Object>
	 * @return Json串
	 */
	public static String convert2Json(Map<?, ?> map) {
		// StringWriter不需要关闭IO流（可见Java源码）
		StringWriter sw = new StringWriter();
		try {
			mapper.writeValue(sw, map);
			return sw.toString();
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 将Json串转成Map 1
	 * 
	 * @param jsonText
	 *            Json串
	 * @return Map
	 */
	public static Map<?, ?> json2Map(String jsonText) {
		try {
			Map<?, ?> map = mapper.readValue(jsonText, HashMap.class);
			return map;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将Json串转成Map 2
	 * 
	 * @param jsonText
	 *            Json串
	 * @return Map
	 */
	public static Map<?, ?> jsonToMap(String jsonText) {
		try {
			JsonFactory jsonFactory = new MappingJsonFactory();
			// Json解析器
			JsonParser jsonParser = jsonFactory.createJsonParser(jsonText);
			// 跳到结果集的开始
			jsonParser.nextToken();
			// 接受结果的HashMap
			HashMap<String, String> map = new HashMap<String, String>();
			// while循环遍历Json结果
			while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
				// 跳转到Value
				jsonParser.nextToken();
				// 将Json中的值装入Map中
				map.put(jsonParser.getCurrentName(), jsonParser.getText());

			}
			return map;
		} catch (Exception e) {
			return null;
		}

	}
}