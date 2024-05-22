package re.kaguya._weibo_kaguya.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import re.kaguya._weibo_kaguya.common.response.JsonResult;
import re.kaguya._weibo_kaguya.common.response.StatusCode;

import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    //校验 DTO 类方式接收数据时的异常;
    @ExceptionHandler
    public JsonResult doHandleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String message = Objects.requireNonNull(ex.getFieldError()).getDefaultMessage();
        log.error("doHandleMethodArgumentNotValidException" + message);
        return new JsonResult(StatusCode.VALIDATED_ERROR, message);
    }
}
