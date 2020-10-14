/**
 * 
 */
package com.lumbu.tradingsignalparser.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lumbu.tradingsignalparser.pojo.request.RequestParams;
import com.lumbu.tradingsignalparser.pojo.trading.Signal;
import com.lumbu.tradingsignalparser.service.TwitterService;

/**
 * @author sugianto.azis@yahoo.com // This Controller is used to handle trading
 *         signal message via rest request
 *
 */
@RestController
@RequestMapping("/parser")
public class ParserController {
	
	@Autowired
	private TwitterService twitterService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/requestSignal")
	@ResponseBody
	public ResponseEntity<Object> requestTwitterSignal(@RequestParam(name = "screen_name") String screenName,
			@RequestParam(name = "count") Integer count) {
		Signal result = new Signal();
		RequestParams params = new RequestParams(screenName, count);
		ResponseEntity<Object> response = null;
		try {
			result = twitterService.callTwitter(params);
			response = ResponseEntity.ok(result);
		} catch (Exception e) {
			logger.error(e.getMessage());
			response = new ResponseEntity<Object>(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
