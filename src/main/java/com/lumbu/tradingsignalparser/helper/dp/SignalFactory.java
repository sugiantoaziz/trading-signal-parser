package com.lumbu.tradingsignalparser.helper.dp;

import org.springframework.stereotype.Component;

import com.lumbu.tradingsignalparser.helper.dp.impl.SiArab;
import com.lumbu.tradingsignalparser.helper.dp.impl.StellaSmith;

@Component
public class SignalFactory {
	public TwitterSignal getSignal(String username) {
		TwitterSignal theSignal = null;
		switch (username) {
		case "forex1997":
			theSignal = new StellaSmith();
			break;
		case "last_news_q8":
			theSignal = new SiArab();
			break;
		default:
			break;
		}
		return theSignal;
	}
}
