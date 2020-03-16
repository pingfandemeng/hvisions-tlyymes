package com.hvisions.mes.configuration;

import com.hvisions.common.advice.ControllerExceptionHandler;
import com.hvisions.common.advice.HvisionsApiResultHandler;
import com.hvisions.common.advice.ResultFactory;
import com.hvisions.common.component.HvisionsI18nInternational;
import com.hvisions.common.utils.HvisionsExceptionMapper;
import com.hvisions.common.utils.LogAopUtil;
import com.hvisions.log.capture.client.LogCaptureClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;

/**
 * <p>Title: AuthConfig</p>
 * <p>Description: 统一配置，可以重写其中的类来实现特定的策略</p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/11/3</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@Configuration
public class Config {
    @Value("${spring.messages.basename}")
    private String basename;

    @Value("${spring.messages.cache-seconds}")
    private long cacheMillis;

    @Value("${spring.messages.encoding}")
    private String encoding;

    @Autowired
    DataSource dataSource;

    /**
     * 日志客户端
     */
    @Autowired
    LogCaptureClient logCaptureClient;
    /**
     * redis处理对象
     */
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * @return 国际化类
     */
    @Bean
    HvisionsI18nInternational getHVisionsI18nInternational() {
        return new HvisionsI18nInternational(basename, cacheMillis, encoding);
    }

    /**
     * @return AOP日志记录
     */
    @Bean
    LogAopUtil getLogAop() {
        return new LogAopUtil(stringRedisTemplate, logCaptureClient);
    }


    /**
     * @return 异常信息处理类
     */
    @Bean
    HvisionsExceptionMapper getHVisionsExceptionMapper() {
        return new HvisionsExceptionMapper();
    }

    /**
     * @param hVisionsI18nInternational 国际化bean
     * @param hVisionsExceptionMapper   异常映射类
     * @return 异常转换类
     */
    @Bean
    ResultFactory getResultVOFactory(HvisionsI18nInternational hVisionsI18nInternational,
                                     HvisionsExceptionMapper hVisionsExceptionMapper) {
        return new ResultFactory(hVisionsI18nInternational, hVisionsExceptionMapper);
    }

    /**
     * @param resultVOFactory 异常转换类
     * @return 全局统一异常处理bean
     */
    @Bean
    ControllerExceptionHandler getControllerExceptionHandler(ResultFactory resultVOFactory) {
        return new ControllerExceptionHandler(resultVOFactory);
    }

    /**
     * @return 全局统一结果处理类
     */
    @Bean
    HvisionsApiResultHandler getHVisionsApiResultHandler() {
        return new HvisionsApiResultHandler();
    }

}
