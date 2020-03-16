package com.hvisions.mes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: SwaggerConfig</p>
 * <p>Description: swagger 功能开启的配置类</p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/9/27</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
     
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build().globalOperationParameters(setHeaderToken());
    }
    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }
     
}