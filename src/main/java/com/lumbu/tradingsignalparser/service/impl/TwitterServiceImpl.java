package com.lumbu.tradingsignalparser.service.impl;

import java.util.List;

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
import com.lumbu.tradingsignalparser.pojo.Root;
import com.lumbu.tradingsignalparser.pojo.TwitterMsg;
import com.lumbu.tradingsignalparser.pojo.request.RequestParams;
import com.lumbu.tradingsignalparser.service.TwitterService;

@Service("twitterService")
public class TwitterServiceImpl implements TwitterService {

	static final String baseUri = "https://api.twitter.com/1.1/statuses/user_timeline.json";

	// change with your own twitter API token
	private static final String token = "AAAAAAAAAAAAAAAAAAAAAFzAIQEAAAAAl27Dk4hypy4FBq7okAck%2BEUlY5g%3DtaZHqPmzpKosHxP9qJOKLXfcVMo3s7Sb3FC96d8JvLBXsSz2DP";

	@Autowired
	private StringHttpMessageConverter stringHttpMessageConverter;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public String callTwitter(RequestParams params) {
		logger.info(params.toString());
		ResponseEntity<String> response = null;
		
		restTemplate().getMessageConverters().add(stringHttpMessageConverter);

		// header config
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		// set request parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUri)
				.queryParam("screen_name", params.getScreenName()).queryParam("count", params.getCount());
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
		}

		// always get newest tweet
		return root.getTwitterMsgs().get(0).getText();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
