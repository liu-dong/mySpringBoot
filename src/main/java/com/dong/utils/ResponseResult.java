package com.dong.utils;

import lombok.Data;

/**
 * @author LD
 * @date 2020/3/22 21:57
 */
@Data
public class ResponseResult {

    private int code = 200;
    private boolean success = true;
    private String message;
    private Object data;

    /**
     * 操作成功
     *
     * @param data
     * @param message
     * @return
     */
    public static ResponseResult success(Object data, String message) {
        ResponseResult result = new ResponseResult();
        result.setCode(200);
        result.setSuccess(true);
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    /**
     * 操作失败
     *
     * @param message
     * @return
     */
    public static ResponseResult error(String message) {
        ResponseResult result = new ResponseResult();
        result.setCode(500);
        result.setSuccess(false);
        result.setMessage(message);
        return result;
    }
}
