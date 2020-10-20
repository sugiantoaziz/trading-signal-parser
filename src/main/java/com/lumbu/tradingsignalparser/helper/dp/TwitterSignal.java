package com.lumbu.tradingsignalparser.helper.dp;

import com.lumbu.tradingsignalparser.pojo.trading.Signal;

public interface TwitterSignal {
	public Signal parseSignal(String tweet);
}
