package com.lumbu.tradingsignalparser.pojo.request;

import lombok.Data;

@Data
public class RequestParams {
	private String screenName;
	
	private Integer count;

	public RequestParams() {
	}

	public RequestParams(String screenName, Integer count) {
		this.screenName = screenName;
		this.count = count;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "RequestParams [screenName=" + screenName + ", count=" + count + "]";
	}

}
