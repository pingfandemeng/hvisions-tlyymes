package com.hvisions.mes.util;

import com.hvisions.mes.enums.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;

/**
 * @description: ajax返回结果对象
 * @author: Bruce
 * @version:
 * @date: 2019-10-03 22:14
 */
@ApiModel(description = "ajax返回结果对象")
public class Result {

    /**
     * 成功编码：默认200
     */
    @ApiModelProperty(value = "成功编码：默认200", readOnly = true)
    private Integer code = 200;

    /**
     * 提示信息
     */
    @ApiModelProperty(value = "提示信息", readOnly = true)
    private String message = "";

    /**
     * 数据对象
     */
    @ApiModelProperty(value = "数据对象", readOnly = true)
    private Object data = null;

    /**
     * 分页对象
     */
    @ApiModelProperty(value = "分页对象", readOnly = true)
    private Page page = null;

    /**
     * 设置成功编码：200或其他
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 设置提示信息
     */
    public void setMessage(String msg) {
        this.message = msg;
    }

    /**
     * 设置返回数据对象
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 信息操作成功
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMessage(Constant.MSG_SUCCESS.getName());
        return result;
    }

    /**
     * 信息操作成功
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setData(data);
        result.setMessage(Constant.MSG_SUCCESS.getName());
        return result;
    }

    /**
     * 信息操作成功
     */
    public static Result success(Object data, String msg) {
        Result result = new Result();
        result.setCode(200);
        result.setData(data);
        result.setMessage(msg);
        return result;
    }
    /**
     * 信息保存成功
     */
    public static Result saveSuccess() {
        Result result = new Result();
        result.setCode(200);
        result.setMessage(Constant.MSG_SUCCESS_SAVE.getName());
        return result;
    }

    /**
     * 信息保存成功
     */
    public static Result updateSuccess() {
        Result result = new Result();
        result.setCode(200);
        result.setMessage(Constant.MSG_SUCCESS_UPDATE.getName());
        return result;
    }

    /**
     * 信息删除成功
     */
    public static Result deleteSuccess() {
        Result result = new Result();
        result.setCode(200);
        result.setMessage(Constant.MSG_SUCCESS_DELETE.getName());
        return result;
    }

    /**
     * 处理失败
     *
     * @return
     */
    public static Result failure() {
        Result result = new Result();
        result.setCode(400);
        return result;
    }

    /**
     * 处理失败
     *
     * @param msg 失败消息
     * @return
     */
    public static Result failure(String msg) {
        Result result = new Result();
        result.setCode(200);
        result.setMessage(msg);
        return result;
    }

    /**
     * 处理失败
     *
     * @param msg 失败消息
     * @param data 数据
     * @return
     */
    public static Result failure(String msg, Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
