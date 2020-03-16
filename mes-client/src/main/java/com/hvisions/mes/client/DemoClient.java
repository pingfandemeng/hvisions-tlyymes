package com.hvisions.mes.client;

import com.hvisions.common.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>Title: DemoClient</p>
 * <p>Description: </p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/11/09</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@FeignClient(name = "mes", fallbackFactory = DemoClientFallBack.class)
public interface DemoClient {

    /**
     * 发布外部接口
     *
     * @param message 登录账号
     * @return 用户ID
     */
    @GetMapping("/demo/interface")
    ResultVO<String> demoInterface(@RequestParam String message);
}
