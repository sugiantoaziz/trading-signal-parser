package com.lumbu.tradingsignalparser.pojo;

import java.io.Serializable;
import java.util.List;

public class Root implements Serializable {
	private List<TwitterMsg> twitterMsgs;

	public List<TwitterMsg> getTwitterMsgs() {
		return twitterMsgs;
	}

	public void setTwitterMsgs(List<TwitterMsg> twitterMsgs) {
		this.twitterMsgs = twitterMsgs;
	}

}
