package com.lumbu.tradingsignalparser.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lumbu.tradingsignalparser.helper.dp.SignalFactory;
import com.lumbu.tradingsignalparser.helper.dp.TwitterSignal;
import com.lumbu.tradingsignalparser.pojo.trading.Signal;

@Component
public class ParseHelper {

	private static ParseHelper helper;
	
	private ParseHelper() {}

	public static ParseHelper getInstance() {
		if (helper == null)
			helper = new ParseHelper();
		return helper;
	}

	public static List<Signal> parse(Map<String, String> tweets) {
		List<Signal> signals = new ArrayList<Signal>();
		SignalFactory signalFactory = new SignalFactory();
		tweets.forEach((k, v) -> {
			Signal signal = new Signal();
			TwitterSignal twitterSignal = signalFactory.getSignal(k);
			signal = twitterSignal.parseSignal(v);
			signals.add(signal);
		});
		return signals;
	}
}
