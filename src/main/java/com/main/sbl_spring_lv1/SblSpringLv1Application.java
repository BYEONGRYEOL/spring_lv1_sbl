package com.main.sbl_spring_lv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing // jpa Auditing 기능을 사용하겠다. db timestamp 위해서
@SpringBootApplication
public class SblSpringLv1Application {

	public static void main(String[] args) {
		SpringApplication.run(SblSpringLv1Application.class, args);
	}

}
