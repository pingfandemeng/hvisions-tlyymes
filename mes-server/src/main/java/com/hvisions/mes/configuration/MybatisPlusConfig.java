package com.hvisions.mes.configuration;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>Title: MybatisPlusConfig</p>
 * <p>Description: MybatisPlus 分页配置</p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2019/08/03</p>
 *
 * @author :yangfan
 * @version :1.0.0
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.tlyy.mes.prodplan.service.*.dao.*")
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
