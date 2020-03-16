package com.hvisions.mes.client;

import com.hvisions.common.exception.BaseFallbackFactory;
import com.hvisions.common.vo.ResultVO;
import org.springframework.stereotype.Component;

/**
 * <p>Title: DemoClientFallBack</p>
 * <p>Description: </p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2019/4/12</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@Component
public class DemoClientFallBack extends BaseFallbackFactory<DemoClient> {

    @Override
    public DemoClient getFallBack(ResultVO vo) {
        return new DemoClient() {
            @Override
            public ResultVO<String> demoInterface(String message) {
                return vo;
            }
        };
    }
}









