package com.lumbu.tradingsignalparser.service;

import java.util.List;

import org.springframework.boot.json.JsonParseException;

import com.lumbu.tradingsignalparser.pojo.request.RequestParams;
import com.lumbu.tradingsignalparser.pojo.trading.Signal;

public interface TwitterService {
	public List<Signal> callTwitter(RequestParams params) throws JsonParseException;
}
