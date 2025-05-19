package com.winningwithwynny.quizzy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="User API",description="Registered User information"))
public class QuizzyApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizzyApplication.class, args);
	}

}
