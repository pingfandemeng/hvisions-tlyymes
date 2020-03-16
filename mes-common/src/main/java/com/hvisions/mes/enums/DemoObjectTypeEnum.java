package com.hvisions.mes.enums;

/**
 * <p>Title: DemoObjectTypeEnum</p>
 * <p>Description: 对象类型枚举</p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/12/6</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
public enum DemoObjectTypeEnum {
    //命名规则：{服务编号}{对象编号}
    //例如：微服务编号11，对象编号1 返回1101
    DEMO_DTO(1),
    ;
    int code;

    DemoObjectTypeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

    
    
    
    
    
    
    
    
