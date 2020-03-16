package com.hvisions.mes.enums;

import com.hvisions.common.interfaces.BaseErrorCode;
import lombok.Getter;

/**
 * <p>Title: DemoExceptionEnum</p>
 * <p>Description: </p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/9/25</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@Getter
public enum MesExceptionEnum implements BaseErrorCode {
    //异常类型,添加枚举时，应该在i18n中添加对应的中英文转换
    DEMO_EXCEPTION_ENUM(30001),
    TOKEN_NOT_EXISTS(30002),
    EXISTS_YEAR_PLAN(30003),
    TEMP_ERROR(30004),
    EXISTS_CLIENT(30005),
    IS_PC(30006),
    ID_NOT_EXIST(30007),
    EQP_DEL_ERROR(30008),
    EQP_DEL_ERROR2(30009),
    EQP_UPDATE_ERROR(30010),
    INDEX_EXIST(30011),
    ;
    private Integer code;

    MesExceptionEnum(Integer code) {
        this.code = code;
    }


    @Override
    public String getMessage() {
        return this.toString();
    }
}
