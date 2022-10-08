package com.example.omar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class OmarApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmarApplication.class, args);
	}

}
