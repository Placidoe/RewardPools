package com.exploreX.config;

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

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
               .select()
               .apis(RequestHandlerSelectors.basePackage("com.example.yourpackage.controller")) // 替换为你项目中实际的Controller所在包路径
               .paths(PathSelectors.any())
               .build()
               .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
               .title("Your API Title") // 替换为你的API文档标题
               .description("Your API Description") // 替换为你的API文档描述内容
               .version("1.0")
               .contact(new Contact("Your Name", "Your Website", "Your Email")) // 填写你的联系信息
               .build();
    }
}