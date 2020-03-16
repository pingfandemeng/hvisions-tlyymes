package com.hvisions.mes.core;

import com.hvisions.common.consts.CookieConst;
import com.hvisions.common.consts.RedisConst;
import com.hvisions.common.exception.BaseKnownException;
import com.hvisions.mes.enums.MesExceptionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: Controller基础公共类
 * @author: Bruce
 * @version:
 * @date: 2019-10-23 09:16
 */
public class BaseController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 获取当前登录人的userid
     * @return userid
     */
    public int getCurrentUser() {
        String token = request.getHeader(CookieConst.AUTH_TOKEN);
        String userIdStr = null;
        if (token != null) {
            userIdStr = stringRedisTemplate.opsForValue()
                    .get(String.format(RedisConst.AUTH_REDIS_PREFIX, token));
        }
        if (null == userIdStr) {
            throw new BaseKnownException(MesExceptionEnum.TOKEN_NOT_EXISTS);
        }
        return Integer.parseInt(userIdStr);
    }
}
