package com.lumbu.tradingsignalparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class TradingSignalParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingSignalParserApplication.class, args);
	}

}
