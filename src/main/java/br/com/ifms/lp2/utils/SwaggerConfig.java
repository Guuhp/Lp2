package br.com.ifms.lp2.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {


      @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build().apiInfo(apiinfo());
    }
 
    private ApiInfo apiinfo(){
        return new ApiInfoBuilder()
        .title("API de LP2")
        .description("API para desenvolver as atividades")
        .license("Apache License Version 2.0")
        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
        .termsOfServiceUrl("/service.html")
        .version("1.0.0")
        .contact(new Contact("Luiz Gustavo", "http://localhost:8080/contact","luiz@gmail.com"))
        .build();
            
    }
}
