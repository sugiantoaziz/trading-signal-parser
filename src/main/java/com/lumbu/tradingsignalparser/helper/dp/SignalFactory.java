package com.lumbu.tradingsignalparser.helper.dp;

import org.springframework.stereotype.Component;

import com.lumbu.tradingsignalparser.constants.Constants;
import com.lumbu.tradingsignalparser.helper.dp.impl.SiArab;
import com.lumbu.tradingsignalparser.helper.dp.impl.StellaSmith;

@Component
public class SignalFactory {
	public TwitterSignal getSignal(String username) {
		TwitterSignal theSignal = null;
		switch (username) {
		case Constants.stella_smith:
			theSignal = new StellaSmith();
			break;
		case Constants.si_arab:
			theSignal = new SiArab();
			break;
		default:
			break;
		}
		return theSignal;
	}
}
