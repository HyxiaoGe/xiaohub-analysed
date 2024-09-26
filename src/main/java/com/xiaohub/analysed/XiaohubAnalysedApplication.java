package com.xiaohub.analysed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class XiaohubAnalysedApplication {

	public static void main(String[] args) {
		SpringApplication.run(XiaohubAnalysedApplication.class, args);
	}

}
