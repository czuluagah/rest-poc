package com.czuluaga.poc.sb.swagger;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private Set<String> setProduceer(){
		HashSet<String> PRODUCES = new HashSet<String>();
		PRODUCES.add("application/json");
		return PRODUCES;
	}

	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.czuluaga.poc.sb.rs"))
				.paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndPointsInfo()).produces(setProduceer());
	}
	

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Spring Boot REST API")
								   .description("Library Management REST API")
								   .contact(new Contact("Carlos Zuluaga", "https://github.com/czuluagah", "carlos.zuluaga@gmail.com"))
								   .license("Apache 2.0")
								   .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0")
								   .build();
	}

}
