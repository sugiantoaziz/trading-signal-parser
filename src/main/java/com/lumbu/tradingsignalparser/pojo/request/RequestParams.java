package com.lumbu.tradingsignalparser.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestParams {
	private String screenName;
	
	private Integer count;

}
