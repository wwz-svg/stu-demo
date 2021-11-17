package com.example.common.model;
/*
 *@ClassName Result
 *@Description TODO
 *@Author 武万章
 *@Date 2021/11/16 13:49
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private T datas;
    private Integer resp_code;
    private String resp_msg;


    public static <T> Result<T> succeed(String msg) {
        return succeedWith(null, 0,msg);
    }

    public static <T> Result<T> succeed(T model, String msg) {
        return succeedWith(model, 0,msg);
    }

    public static <T> Result<T> succeedWith(T datas, Integer code,String msg) {
        return new Result<T>(datas, code, msg);
    }

    public static <T> Result<T> failed(String msg) {
        return failedWith(null, -1, msg);
    }

    public static <T> Result<T> failed(T model,String msg) {
        return failedWith(model, -1, msg);
    }

    public static <T> Result<T> failedWith(T datas, Integer code, String msg) {
        return new Result<T>( datas, code, msg);
    }

}