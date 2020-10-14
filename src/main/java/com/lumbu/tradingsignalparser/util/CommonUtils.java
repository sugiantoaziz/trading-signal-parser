package com.lumbu.tradingsignalparser.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class CommonUtils {
	
	private static  CommonUtils commonUtils;
	
	public static CommonUtils getInstance()
	{
		if(commonUtils==null)
			commonUtils= new CommonUtils();
		return commonUtils;
	}
	public  String objToJson(Object obj) {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = "";
		try {
			json = ow.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;
	}
}
