package com.lumbu.tradingsignalparser.service;

import org.springframework.boot.json.JsonParseException;

import com.lumbu.tradingsignalparser.pojo.request.RequestParams;

public interface TwitterService {
	public String callTwitter(RequestParams params) throws JsonParseException;
}
