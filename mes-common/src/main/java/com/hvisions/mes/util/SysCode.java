package com.hvisions.mes.util;

import com.google.common.collect.Maps;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 状态码维护
 * @author: Bruce
 * @version:
 * @date: 2020-01-17 10:14
 */
@Data
public class SysCode {

    /**
     * 系统状态码
     */
    private String sysCode;

    /**
     * 状态码描述
     */
    private String sysDesc;

    /**
     * 伴生状态码
     */
    private String assoCode;

    /**
     * 状态码描述
     */
    private String assoDesc;

//    protected static final Map<String, SysCode> codeMap = Maps.newHashMap();
//
//    public static SysCode SUCCEED = new SysCode("200","成功", "200") ;
//
//    /**
//     * 含参构造
//     * @param assoCode 伴生状态码
//     * @param assoDesc 伴生状态码说明
//     * @param sysCode 系统状态码
//     */
//    public SysCode(String assoCode, String assoDesc,String sysCode) {
//        this.sysCode = assoCode;
////        this.sysDesc = sysCodeMap.get(sysCode);
//        this.assoCode = assoCode;
//        this.assoDesc = assoDesc;
//
//        // 当状态码位新增状态时
//        if(StringUtils.isEmpty(this.sysDesc)){
//            this.sysDesc = assoCode;
//        }
//        codeMap.put(assoCode,this);
//    }
//
//    /**
//     * 静态含参构造
//     * @param asso_code 伴生状态码
//     * @param asso_desc 伴生状态码说明
//     * @param sys_code 系统状态码
//     */
//    public static SysCode container(String asso_code, String asso_desc,String sys_code) {
//        return new SysCode(asso_code, asso_desc, sys_code);
//    }
//
//    /**
//     * 根据伴生状态码获取对象
//     * @param assoCode 伴生状态码
//     * @return 状态码对象
//     */
//    public static SysCode get(String assoCode) {
//        return codeMap.get(assoCode);
//    }

    /**
     *  设备检修状态
     */
    public static final Map<Integer ,String> equipmentOverhaulStatus = new HashMap<Integer ,String>(){
        private static final long serialVersionUID = 1L;
        {
            put(1, "新建");
            put(2, "检修中");
            put(3, "完成检修");
            put(4, "延期中");
        }};

    public static void main(String[] args){
        System.out.println(equipmentOverhaulStatus.get(1));
    }

}
