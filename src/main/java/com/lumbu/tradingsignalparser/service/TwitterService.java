package com.lumbu.tradingsignalparser.service;

import org.springframework.boot.json.JsonParseException;

import com.lumbu.tradingsignalparser.pojo.request.RequestParams;
import com.lumbu.tradingsignalparser.pojo.trading.Signal;

public interface TwitterService {
	public Signal callTwitter(RequestParams params) throws JsonParseException;
}
