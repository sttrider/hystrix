package br.com.joao.hystrix.example.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.joao.hystrix.example.service.TestService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ExampleRunner implements ApplicationRunner {

	@Autowired
	private TestService testService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		log.info("before call");

		String a = testService.test();
		log.info(a);
	}

}
