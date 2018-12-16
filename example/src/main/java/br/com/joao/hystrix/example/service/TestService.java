package br.com.joao.hystrix.example.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestService {

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500") })
	public String test() throws InterruptedException {
		log.info("init");
		Thread.sleep(400);
		log.info("end");
		return "success";
	}

	public String fallback() {
		log.info("fallback");
		return "error";
	}
}
