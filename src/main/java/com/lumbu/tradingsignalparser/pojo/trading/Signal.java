package com.lumbu.tradingsignalparser.pojo.trading;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Signal {

	// ex: EURUSD
	private String instrument;

	// ex: buy or sell from 1.17960
	private HashMap<String, BigDecimal> order;

	// ex: [tp1 1.18737, tp2 1.19026, tp3 1.19674]
	private ArrayList<HashMap<String, BigDecimal>> takeProfit;

	// ex: sl 1.16958
	private BigDecimal stopLoss;

	
}
