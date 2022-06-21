package com.jessat18.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class PlatziMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatziMarketApplication.class, args);
	}

}
