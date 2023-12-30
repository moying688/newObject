package com.sky.handler;

<<<<<<< HEAD
import com.sky.constant.MessageConstant;
import com.sky.exception.BaseException;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.Message;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

=======
import com.sky.exception.BaseException;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae
/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }
<<<<<<< HEAD
    //Duplicate entry 'test' for key 'employee.idx_username'
    @ExceptionHandler
    public Result UserExceptionHandler(SQLIntegrityConstraintViolationException ex){
        String message = ex.getMessage();
        String[]split=message.split(" ");
        String username=split[2];
        if(message.contains("Duplicate entry")){
            log.error("此{"+username+"}用户名重复: ");
            return Result.error("用户名重复("+username+")");

        }
        else {
            return Result.error(MessageConstant.UNKNOWN_ERROR);
        }
    }
=======
>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae

}
