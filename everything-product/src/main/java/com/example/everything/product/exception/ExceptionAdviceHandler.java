package com.example.everything.product.exception;

import com.example.everything.common.exception.BusinessException;
import com.example.everything.common.response.ObjectResponse;
import com.example.everything.common.response.ReturnCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author win10
 */
@RestControllerAdvice
public class ExceptionAdviceHandler {


    @ExceptionHandler({Exception.class})
    public ObjectResponse<String> handler(Exception e) {
        ObjectResponse<String> error = new ObjectResponse<>();
        if (e instanceof BusinessException) {
            error.setCode(((BusinessException) e).getCode());
            error.setMessage(e.getMessage());
        } else {
            error.setCode(ReturnCode.ERROR_CODE);
            error.setMessage(e.getMessage());
        }
        return error;
    }

}
