package com.lumbu.tradingsignalparser.pojo.request;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestParams {
	private ArrayList<String> screenNames;
	
	private Integer count;

}
