package com.hvisions.mes.enums;

/**
 * @description: 常量
 * @author: Bruce
 * @version:
 * @date: 2019-09-18 14:30
 */
public enum Constant {

    // 删除（是）
    YES_DEL(1, "是"),
    // 删除（否）
    NO_DEL(0, "否"),

    // controller操作提示
    MSG_SUCCESS(1, "信息操作成功"),
    MSG_SUCCESS_SAVE(2, "信息添加成功"),
    MSG_SUCCESS_UPDATE(3, "信息修改成功"),
    MSG_SUCCESS_DELETE(4, "信息删除成功"),
    MSG_ERROR(5, "服务器异常，操作失败"),

    /*******************年度计划部分*******************/
    // 是否已经自动排产（0否，1是）
    YES_PC(1, "是"),
    NO_PC(0,"否"),

    /*******************来料检验部分*******************/
    // 是否合格供应商（0否，1是）
    YES_QUALIFIED_SUPPLIER(1, "是"),
    NO_QUALIFIED_SUPPLIER(0, "否"),
    // 查看供方COA信息与包装信息是否一致（0否，1是）
    YES_COA_AND_INFO(1, "是"),
    No_COA_AND_INFO(0, "否"),
    // 卫生情况（0不卫生，1卫生）
    YES_HEALTH(1, "卫生"),
    NO_HEALTH(0, "不卫生"),
    // 虫害情况（0无，1有）
    YES_INSECT_ATTACK(1, "有"),
    NO_INSECT_ATTACK(0, "无"),
    // 防护措施（0不齐全，1齐全）
    YES_SAFEGUARD_PROCEDURES(1, "齐全"),
    NO_SAFEGUARD_PROCEDURES(0, "不齐全"),
    // 拼车（0否，1是）
    YES_SHARE_CAR(1, "是"),
    NO_SHARE_CAR(0, "否"),
    // 若拼车（0有污染，1无污染）
    YES_POLLUTE(1, "无污染"),
    NO_POLLUTE(0, "有污染"),
    // 规格，型号，数量是否与采购通知单一致（0否，1是）
    YES_INFO_AND_NOTICE(1, "是"),
    NO_INFO_AND_NOTICE(0, "否"),
    // 外包装是否规范，卫生，无虫害（0否，1是）
    YES_PACK_STANDARD(1, "是"),
    NO_PACK_STANDARD(0, "否"),
    // 标签内容是否完整清晰（0否，1是）
    YES_LABEL_CONTENT_OK(1, "是"),
    NO_LABEL_CONTENT_OK(0, "否"),
    // 放行结论（0否，1是）
    YES_FX_RESULT(1, "是"),
    NO_FX_RESULT(0, "否"),
    // 当前责任人的状态（当前信息状态：0新建基础信息，1车辆检验 2取样检验 3确认检验 4确认放行）
    ZERO_CURR_STATE(0, "新建基础信息"),
    ONE_CURR_STATE(1, "车辆检验"),
    TWO_CURR_STATE(2, "取样检验"),
    THREE_CURR_STATE(3, "确认检验"),
    FOUR_CURR_STATE(4, "确认放行"),

    // 计划停车审核状态
    APPROVING(1, "审核中"),
    APPROVE_PASS(2, "通过"),
    APPROVE_REFUSE(3, "拒绝");


    private Integer code;
    private String name;

    Constant(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
