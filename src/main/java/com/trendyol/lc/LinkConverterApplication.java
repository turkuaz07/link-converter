package com.trendyol.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class LinkConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkConverterApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
	    return new OpenAPI()
	      .info(new Info()
	      .title("Link Converter API")
	      .description("Trendyol Link Converter Backend App"));
	}
}
