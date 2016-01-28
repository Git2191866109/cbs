package com.bs.plugins.thirdparty.sms.ymsms;

import java.util.Map;

import net.sf.json.xml.XMLSerializer;

public class XMLUtil {
	
    /**
     * xml to map
     * @param xml
     * @return
     */
    public static Map<String, Object> xml2Map(String xml) {
        return null;
    }
    
    
    /** 
     * xml to json 
     * @param xml 
     * @return 
     */  
    public static String xmltoJson(String xml) {  
        XMLSerializer xmlSerializer = new XMLSerializer();  
        return xmlSerializer.read(xml).toString();  
    }  
    
    public static void main(String[] args) {
		
		//String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
		//+"<response><error>0</error><message><srctermid>15011169565</srctermid><submitDate>20151127163731</submitDate>"
		//+"<receiveDate>20151127163735</receiveDate><addSerial></addSerial><addSerialRev></addSerialRev><state>DELIVRD</state>"
		//+"<seqid>1448613453553</seqid></message><message><srctermid>15011169565</srctermid>"
		//+"<submitDate>20151127163746</submitDate><receiveDate>20151127163751</receiveDate>"
		//+"<addSerial></addSerial><addSerialRev></addSerialRev><state>DELIVRD</state><seqid>1448613468327</seqid>"
		//+"</message><message><srctermid>15011169565</srctermid><submitDate>20151127163757</submitDate>"
		//+"<receiveDate>20151127163759</receiveDate><addSerial></addSerial><addSerialRev></addSerialRev>"
		//+"<state>DELIVRD</state><seqid>1448613478472</seqid>"
		//+"</message></response>";
		    	
		//{"message":[{"receiveDate":"20151127163735","seqid":"1448613453553","addSerial":[],"submitDate":"20151127163731","state":"DELIVRD","srctermid":"15011169565","addSerialRev":[]},{"seqid":"1448613468327","receiveDate":"20151127163751","addSerial":[],"submitDate":"20151127163746","state":"DELIVRD","addSerialRev":[],"srctermid":"15011169565"},{"seqid":"1448613478472","receiveDate":"20151127163759","addSerial":[],"submitDate":"20151127163757","state":"DELIVRD","addSerialRev":[],"srctermid":"15011169565"}],"error":"0"}
		
		    	
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response><error>0</error><message></message></response>";
		//{"message":[],"error":"0"}
		
		try {
			
			System.err.println(xmltoJson(xml));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}
