package re.kaguya._05mvcboot3.common.exception;

import jakarta.validation.UnexpectedTypeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import re.kaguya._05mvcboot3.common.response.JsonResult;
import re.kaguya._05mvcboot3.common.response.StatusCode;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public JsonResult doHandleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String message = ex.getMessage();
        log.error("MethodArgumentNotValidException:" + message);
        return new JsonResult(StatusCode.VALIDATED_ERROR, "标题不能为空... ... 等等");
    }

    @ExceptionHandler
    public JsonResult doUnexpectedTypeException(MethodArgumentTypeMismatchException ex) {
        String message = ex.getMessage();
        log.error("MethodArgumentTypeMismatchException:" + message);
        return new JsonResult(StatusCode.VALIDATED_ERROR, "文章id必须在1-100之间");
    }
}
