package re.kaguya._05weibo.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import re.kaguya._05weibo.response.JsonResult;
import re.kaguya._05weibo.response.StatusCode;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public JsonResult doHandleRuntimeException(RuntimeException e) {
        String message = e.getMessage();
        log.error(message);
        return new JsonResult(StatusCode.OPERATION_FAILED, message);
    }

    @ExceptionHandler
    public JsonResult doHandleThrowable(Throwable e) {
        String message = e.getMessage();
        log.error("doHandleThrowable:" + message);
        return new JsonResult(StatusCode.THROWABLE_ERROR, message);
    }
}
