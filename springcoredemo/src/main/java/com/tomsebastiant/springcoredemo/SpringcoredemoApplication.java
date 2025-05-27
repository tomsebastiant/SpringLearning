package com.tomsebastiant.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// By default, spring will m component scan only its base package and its sub packages. To
// scan other packages you need to explicitly define them as below with scanBasePackages
//@SpringBootApplication(
//		scanBasePackages = {"com.tomsebastiant.util",
//							"com.tomsebastiant.springcoredemo"}
//)

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
