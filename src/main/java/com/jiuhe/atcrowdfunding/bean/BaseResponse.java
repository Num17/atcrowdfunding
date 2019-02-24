package com.jiuhe.atcrowdfunding.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用response
 */
public class BaseResponse {

    //失败状态码
    private static final Integer ERROR_STATUS_CODE = 0;
    //成功状态码
    private static final Integer SUCCESS_STATUS_CODE = 1;

    //处理失败
    public static final BaseResponse ERROR_RESPONSE = new BaseResponse(ERROR_STATUS_CODE);
    //处理成功
    public static final BaseResponse SUCCESS_RESPONSE = new BaseResponse(SUCCESS_STATUS_CODE);


    //状态码
    private Integer statusCode;
    //    private Integer messageCode;//信息码
    //信息
    private String message;
    //数据
    private Map<String, Object> data = new HashMap<>();

    public BaseResponse() {

    }

    private BaseResponse(Integer statusCode) {
        this.statusCode = statusCode;
    }

    private BaseResponse(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public static BaseResponse newErrorResponse(String message) {
        return new BaseResponse(ERROR_STATUS_CODE, message);
    }

    public static BaseResponse newSuccessResponse(String message) {
        return new BaseResponse(SUCCESS_STATUS_CODE, message);
    }

    public BaseResponse put(String key, Object object) {
        this.data.put(key, object);
        return this;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getData() {
        return data;
    }


}
