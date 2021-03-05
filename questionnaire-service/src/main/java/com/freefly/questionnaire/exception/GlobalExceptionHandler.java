package com.freefly.questionnaire.exception;

import com.freefly.questionnaire.vo.ResultEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/12/8 13:42
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {NullPointerException.class})
    public ResultEntity business(NullPointerException ex) {
        return ResultEntity.failedWithoutData(402, ex.getMessage());
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public ResultEntity business(MethodArgumentTypeMismatchException ex) {
        return ResultEntity.failedWithoutData(402, ex.getMessage());
    }
}
