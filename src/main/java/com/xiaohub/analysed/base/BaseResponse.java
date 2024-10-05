package com.xiaohub.analysed.base;

import lombok.Data;

import java.util.Map;

@Data
public class BaseResponse {

    // 响应业务状态码
    private Integer status;

    // 响应消息
    private String msg;

    // 是否成功
    private Boolean success;

    // 响应数据，可以是Object，也可以是List或Map等
    private Object data;

    /**
     * 成功返回，带有数据的，直接往OK方法丢data数据即可
     * @param data
     * @return
     */
    public static BaseResponse ok(Object data) {
        return new BaseResponse(ResponseStatusEnum.SUCCESS, data);
    }
    
    /**
     * 成功返回，不带有数据的，直接调用ok方法，data无须传入（其实就是null）
     * @return
     */
    public static BaseResponse ok() {
        return new BaseResponse(ResponseStatusEnum.SUCCESS);
    }
    public BaseResponse(Object data) {
        this.status = ResponseStatusEnum.SUCCESS.status();
        this.msg = ResponseStatusEnum.SUCCESS.msg();
        this.success = ResponseStatusEnum.SUCCESS.success();
        this.data = data;
    }


    /**
     * 错误返回，直接调用error方法即可，当然也可以在ResponseStatusEnum中自定义错误后再返回也都可以
     * @return
     */
    public static BaseResponse error() {
        return new BaseResponse(ResponseStatusEnum.FAILED);
    }

    /**
     * 错误返回，map中包含了多条错误信息，可以用于表单验证，把错误统一的全部返回出去
     * @param map
     * @return
     */
    public static BaseResponse errorMap(Map map) {
        return new BaseResponse(ResponseStatusEnum.FAILED, map);
    }

    /**
     * 错误返回，直接返回错误的消息
     * @param msg
     * @return
     */
    public static BaseResponse errorMsg(String msg) {
        return new BaseResponse(ResponseStatusEnum.FAILED, msg);
    }

    /**
     * 自定义错误范围，需要传入一个自定义的枚举，可以到[ResponseStatusEnum.java[中自定义后再传入
     * @param responseStatus
     * @return
     */
    public static BaseResponse errorCustom(ResponseStatusEnum responseStatus) {
        return new BaseResponse(responseStatus);
    }
    public static BaseResponse exception(ResponseStatusEnum responseStatus) {
        return new BaseResponse(responseStatus);
    }

    public BaseResponse(ResponseStatusEnum responseStatus) {
        this.status = responseStatus.status();
        this.msg = responseStatus.msg();
        this.success = responseStatus.success();
    }
    public BaseResponse(ResponseStatusEnum responseStatus, Object data) {
        this.status = responseStatus.status();
        this.msg = responseStatus.msg();
        this.success = responseStatus.success();
        this.data = data;
    }
    public BaseResponse(ResponseStatusEnum responseStatus, String msg) {
        this.status = responseStatus.status();
        this.msg = msg;
        this.success = responseStatus.success();
    }

    public BaseResponse() {
    }

}
