package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;

@SpringBootTest
@RestController
class  DemoApplicationTests {
	public static void main(String[] args){
		SpringApplication.run(DemoApplication.class, args);
	}
	@Test
	void contextLoads() {
	}

}
