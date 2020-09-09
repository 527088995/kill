package com.debug.kill.log.base;


import com.debug.kill.log.log.LogManager;
import com.debug.kill.log.log.LogTaskFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String notFount(RuntimeException e) {
        LogManager.me().executeLog(LogTaskFactory.exceptionLog("", "", "", "", e));
        log.error("运行时异常:", e);
        return "FAIL";
    }
}
