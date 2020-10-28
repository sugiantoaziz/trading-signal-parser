package com.lumbu.tradingsignalparser.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

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

	public String objToJson(Object obj) {
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

	public HashMap<String, BigDecimal> subParse(String line, String pattern) {
		String key = splitString(line, pattern, 0).toLowerCase();
		BigDecimal value = new BigDecimal(0);
		if (pattern.equals("."))
			value = new BigDecimal(splitString(line, pattern, 1).concat(".").concat(splitString(line, pattern, 2)));
		else
			value = new BigDecimal(splitString(line, pattern, 1));
		HashMap<String, BigDecimal> parsedLine = new HashMap<String, BigDecimal>();
		parsedLine.put(key, value);
		return parsedLine;
	}

	public String splitString(String rawString, String pattern, int index) {
		String[] splittedString = rawString.split(Pattern.quote(pattern));
		List<String> listString = Arrays.asList(splittedString);
		String stringResult = "";
		for (int i = 0; i < listString.size(); i++) {
			stringResult = listString.get(index);
		}
		return stringResult.trim();
	}
}
