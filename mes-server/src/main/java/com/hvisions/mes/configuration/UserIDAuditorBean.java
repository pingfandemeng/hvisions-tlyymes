package com.hvisions.mes.configuration;

import com.hvisions.common.consts.CookieConst;
import com.hvisions.common.consts.RedisConst;
import com.hvisions.common.exception.BaseKnownException;
import com.hvisions.mes.core.BaseController;
import com.hvisions.mes.enums.MesExceptionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @Author: Lau
 * @Description:
 * @Date: Created in 17:29 2020/3/9
 * @Modified By:
 */
@Configuration
public class UserIDAuditorBean implements AuditorAware<Integer> {

    @Autowired
    HttpServletRequest request;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public Optional<Integer> getCurrentAuditor() {
        String token = request.getHeader(CookieConst.AUTH_TOKEN);
        String userIdStr = null;
        if (token != null) {
            userIdStr = stringRedisTemplate.opsForValue()
                    .get(String.format(RedisConst.AUTH_REDIS_PREFIX, token));
            return Optional.of(Integer.parseInt(userIdStr));
        }

        return Optional.ofNullable(null);


    }
}
