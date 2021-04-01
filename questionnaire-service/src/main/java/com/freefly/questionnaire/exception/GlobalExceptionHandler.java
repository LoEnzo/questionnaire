package com.freefly.questionnaire.exception;

import com.freefly.questionnaire.vo.ResultEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ProjectName:
 * ClassName:
 * Class Description: 全局异常捕获
 *
 * @Author hjwu
 * @Date2020/12/8 13:42
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {NullPointerException.class})
    public ResultEntity business(NullPointerException ex) {
        return ResultEntity.failedWithData(402, "后台返回异常", ex.getMessage());
    }
}
