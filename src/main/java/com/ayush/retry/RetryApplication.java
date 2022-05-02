package com.ayush.retry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@SpringBootApplication
public class RetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetryApplication.class, args);
	}

	@Bean
	public RetryTemplate retryTemplate(){
		RetryTemplate retryTemplate=new RetryTemplate();

		FixedBackOffPolicy fixedBackOffPolicy=new FixedBackOffPolicy();
		fixedBackOffPolicy.setBackOffPeriod(1000);
		retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

		SimpleRetryPolicy simpleRetryPolicy=new SimpleRetryPolicy();
		simpleRetryPolicy.setMaxAttempts(5);
		retryTemplate.setRetryPolicy(simpleRetryPolicy);
		return retryTemplate;
	}

}
