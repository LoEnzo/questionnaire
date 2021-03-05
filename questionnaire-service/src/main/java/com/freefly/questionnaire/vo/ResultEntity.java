package com.freefly.questionnaire.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/12/6 16:51
 */
@Getter
@Setter
public class ResultEntity<T> implements Serializable {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    //描述返回状态码
    private int code;
    //返回的信息
    private String message;
    //返回的数据
    private T data;

    public ResultEntity(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // 返回成功
    public static <E> ResultEntity<E> successWithData(int code, E data) {
        return new ResultEntity<>(code, SUCCESS, data);
    }

    // 返回成功自定义信息
    public static <E> ResultEntity<E> successWithData(int code, String msg, E data) {
        return new ResultEntity<>(code, msg, data);
    }

    // 返回成功，无返回数据
    public static <E> ResultEntity<E> successWithoutData(int code) {
        return new ResultEntity<>(code, SUCCESS);
    }

    // 返回成功，自定义信息，无返回数据
    public static <E> ResultEntity<E> successWithoutData(int code, String msg) {
        return new ResultEntity<>(code, msg);
    }

    // 返回失败
    public static <E> ResultEntity<E> failedWithData(int code, E data) {
        return new ResultEntity<>(code, FAILED, data);
    }

    // 返回失败自定义信息
    public static <E> ResultEntity<E> failedWithData(int code, String msg, E data) {
        return new ResultEntity<>(code, msg, data);
    }

    // 返回失败，无返回数据
    public static <E> ResultEntity<E> failedWithoutData(int code) {
        return new ResultEntity<>(code, FAILED);
    }

    // 返回失败，自定义信息，无返回数据
    public static <E> ResultEntity<E> failedWithoutData(int code, String msg) {
        return new ResultEntity<>(code, msg);
    }

    public ResultEntity() {
    }
}
