package com.lumbu.tradingsignalparser.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

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

	public static Signal parse(String tweet) {
		String newLine = "\n";
		String space = " ";
		String dot = ".";
		int tpIndex = 0;

		String instrument = splitString(tweet, newLine, 0).replace('#', ' ').trim();
		String order = splitString(tweet, newLine, 1);
		String tp1 = splitString(tweet, newLine, tpIndex = 2);
		String tp2 = tweet.toLowerCase().contains("tp2") ? splitString(tweet, newLine, tpIndex += 1) : "";
		String tp3 = tweet.toLowerCase().contains("tp3") ? splitString(tweet, newLine, tpIndex += 1) : "";
		String slLine = splitString(tweet, newLine, tpIndex += 1);
		BigDecimal sl = new BigDecimal(StringUtils.split(slLine)[1]);

		HashMap<String, BigDecimal> parsedOrder = subParse(order, space);
		HashMap<String, BigDecimal> parsedTp1 = subParse(tp1, dot);
		HashMap<String, BigDecimal> parsedTp2 = StringUtils.isNotBlank(tp2) ? subParse(tp2, dot)
				: new HashMap<String, BigDecimal>();
		HashMap<String, BigDecimal> parsedTp3 = StringUtils.isNotBlank(tp3) ? subParse(tp3, dot)
				: new HashMap<String, BigDecimal>();
		ArrayList<HashMap<String, BigDecimal>> takeProfit = new ArrayList<HashMap<String, BigDecimal>>();
		takeProfit.add(parsedTp1);
		takeProfit.add(parsedTp2);
		takeProfit.add(parsedTp3);

		/* kela */
//		Signal signal = new Signal();
//		SignalFactory signalFactory = new SignalFactory();
//		TwitterSignal stellaSmith = signalFactory.getSignal("stella");
//		signal = stellaSmith.parseSignal(tweet);
//		TwitterSignal siArab = signalFactory.getSignal("arab");
//		signal = siArab.parseSignal(tweet);

		Signal signal = new Signal(instrument, parsedOrder, takeProfit, sl);
		return signal;
	}

	private static HashMap<String, BigDecimal> subParse(String line, String pattern) {
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

	private static String splitString(String rawString, String pattern, int index) {
		String[] splittedString = rawString.split(Pattern.quote(pattern));
		List<String> listString = Arrays.asList(splittedString);
		String stringResult = "";
		for (int i = 0; i < listString.size(); i++) {
			stringResult = listString.get(index);
		}
		return stringResult.trim();
	}
}
