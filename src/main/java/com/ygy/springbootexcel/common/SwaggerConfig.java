package com.ygy.springbootexcel.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * project_name: springboot-excel
 * describe: swagger配置
 *
 * @author : yanguangyuan
 * creat_date: 2018-12-25 14:57
 **/
@Configuration
@EnableSwagger2
@ComponentScan(basePackages="com.ygy.springbootexcel.controller")
public class SwaggerConfig {
    @Value("${swagger.basePackage}")
    private String basePackage;

    @Bean
    public Docket api(){
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        ticketPar.name("token").description("token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(ticketPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("api-1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ygy.springbootexcel.controller"))
                .build().globalOperationParameters(pars);
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("项目API文档")
                .description("HTTP对外开放接口")
                .version("1.0.0")
                .termsOfServiceUrl("http://localhost:8888")
                .license("LICENSE")
                .build();
    }
}
