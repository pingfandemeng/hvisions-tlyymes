package com.hvisions.mes.advice;

import com.hvisions.common.consts.CookieConst;
import com.hvisions.common.consts.RedisConst;
import com.hvisions.mes.dto.prodplan.SysBaseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * <p>Title: DtoControlAdvice</p>
 * <p>Description: 控制器增强，统一处理入参的修改人和增加人 </p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/11/7</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@ControllerAdvice
@Slf4j
@Component
public class DtoControlAdvice implements RequestBodyAdvice {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    HttpServletRequest request;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        //判断最终的对象是否是SysBaseDto的子类
        if (!(body instanceof SysBaseDTO)) {
            return body;
        }
        SysBaseDTO sysBaseDTO = (SysBaseDTO) body;
        //传递当前时间
        sysBaseDTO.setCreateTime(new Date());
        sysBaseDTO.setUpdateTime(new Date());
        //从请求中获取用户sessionId
        String token = request.getHeader(CookieConst.AUTH_TOKEN);
        //如果token不是空，根据sessionId获取redis中的用户id,如果前端没有传递用户id，则添加
        if (token != null) {
            String userIdStr = stringRedisTemplate.opsForValue()
                    .get(String.format(RedisConst.AUTH_REDIS_PREFIX, token));
            if (userIdStr != null) {
                int userId = Integer.valueOf(userIdStr);
                if (sysBaseDTO.getUpdaterId() == null || sysBaseDTO.getUpdaterId() == 0) {
                    sysBaseDTO.setUpdaterId(userId);
                }
                if (sysBaseDTO.getCreatorId() == null || sysBaseDTO.getCreatorId() == 0) {
                    sysBaseDTO.setCreatorId(userId);
                }
            }
        }
        return sysBaseDTO;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type
            targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }
}
