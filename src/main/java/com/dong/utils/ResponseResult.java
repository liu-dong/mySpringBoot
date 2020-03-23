package com.dong.utils;

import lombok.Data;

/**
 * @author LD
 * @date 2020/3/22 21:57
 */
@Data
public class ResponseResult {

    private int code = 200;
    private boolean success = false;
    private String message;
    private Object data;

}
