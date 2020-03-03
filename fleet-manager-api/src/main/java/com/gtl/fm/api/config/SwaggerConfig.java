package com.gtl.fm.api.config;

import java.sql.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any()).build().apiInfo(apiInfo())
            .directModelSubstitute(Date.class, Long.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Fleet Manager Service API", "Fleet Manager Service API.", "Version 1.0", "Terms of service",
            new Contact("", "", ""), "License of API", "API license URL");
    }

}
