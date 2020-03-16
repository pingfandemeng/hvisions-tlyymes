package com.hvisions.mes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Title: DemoApplication</p>
 * <p>Description: </p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/11/7</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.hvisions.mes.*.dao")
@ComponentScan(basePackages = {"com.hvisions.work.plan.client",
        "com.hvisions.mes",
        "com.hvisions.materialsmsd.materials.client",
        "com.hvisions.auth.client"})
@EnableFeignClients(basePackages = {"com.hvisions.log.capture.client",
        "com.hvisions.work.plan.client",
        "com.hvisions.materialsmsd.materials.client",
        "com.hvisions.auth.client"})
@EnableSwagger2
@EnableScheduling
@EnableJpaAuditing
public class MesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MesApplication.class, args);
    }

}
