package com.lumbu.tradingsignalparser.helper.dp.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.lumbu.tradingsignalparser.helper.dp.TwitterSignal;
import com.lumbu.tradingsignalparser.pojo.trading.Signal;
import com.lumbu.tradingsignalparser.util.CommonUtils;

@Component
public class StellaSmith implements TwitterSignal {

	@Override
	public Signal parseSignal(String tweet) {
		String newLine = "\n";
		String space = " ";
		String dot = ".";
		int tpIndex = 0;

		CommonUtils utils = CommonUtils.getInstance();
		String instrument = utils.splitString(tweet, newLine, 0).replace('#', ' ').trim();
		String order = utils.splitString(tweet, newLine, 1);
		String tp1 = utils.splitString(tweet, newLine, tpIndex = 2);
		String tp2 = tweet.toLowerCase().contains("tp2") ? utils.splitString(tweet, newLine, tpIndex += 1) : "";
		String tp3 = tweet.toLowerCase().contains("tp3") ? utils.splitString(tweet, newLine, tpIndex += 1) : "";
		String slLine = utils.splitString(tweet, newLine, tpIndex += 1);
		BigDecimal sl = new BigDecimal(StringUtils.split(slLine)[1]);

		HashMap<String, BigDecimal> parsedOrder = utils.subParse(order, space);
		HashMap<String, BigDecimal> parsedTp1 = utils.subParse(tp1, dot);
		HashMap<String, BigDecimal> parsedTp2 = StringUtils.isNotBlank(tp2) ? utils.subParse(tp2, dot)
				: new HashMap<String, BigDecimal>();
		HashMap<String, BigDecimal> parsedTp3 = StringUtils.isNotBlank(tp3) ? utils.subParse(tp3, dot)
				: new HashMap<String, BigDecimal>();
		ArrayList<HashMap<String, BigDecimal>> takeProfit = new ArrayList<HashMap<String, BigDecimal>>();
		takeProfit.add(parsedTp1);
		takeProfit.add(parsedTp2);
		takeProfit.add(parsedTp3);

		return new Signal(instrument, parsedOrder, takeProfit, sl);
	}

}
