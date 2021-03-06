package com.lumbu.tradingsignalparser.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumbu.tradingsignalparser.helper.ParseHelper;
import com.lumbu.tradingsignalparser.pojo.request.RequestParams;
import com.lumbu.tradingsignalparser.pojo.response.Root;
import com.lumbu.tradingsignalparser.pojo.response.TwitterMsg;
import com.lumbu.tradingsignalparser.pojo.trading.Signal;
import com.lumbu.tradingsignalparser.service.TwitterService;

@Service("twitterService")
public class TwitterServiceImpl implements TwitterService {

	private static final String baseUri = "https://api.twitter.com/1.1/statuses/user_timeline.json";

	// change with your own twitter API token
	private static final String token = "your-token";

	@Autowired
	private StringHttpMessageConverter stringHttpMessageConverter;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Signal> callTwitter(RequestParams params) {
		logger.info(params.toString());
		ResponseEntity<String> response = null;
		
		restTemplate().getMessageConverters().add(stringHttpMessageConverter);

		// header config
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		Map<String, String> tweets = new HashMap<String, String>();
		// set request parameters
		for (String screenName : params.getScreenNames()) {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUri)
					.queryParam("screen_name", screenName).queryParam("count", params.getCount());
			HttpEntity<String> entity = new HttpEntity<String>(headers);

			ObjectMapper objectMapper = new ObjectMapper();
			Root root = new Root();
			logger.info("--------------uri--------" + builder.toUriString());
			try {
				response = restTemplate().exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
				root.setTwitterMsgs(objectMapper.readValue(response.getBody(), new TypeReference<List<TwitterMsg>>() {
				}));// mapping response body content into pojo
			} catch (Exception e) {
				logger.error("Exception insertParametro[WS BO]: ", e);
				break;
			}

			// always get newest tweet
			String tweet = root.getTwitterMsgs().get(0).getText();
			tweets.put(screenName, tweet);
		}

		ParseHelper.getInstance();
		return ParseHelper.parse(tweets);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
