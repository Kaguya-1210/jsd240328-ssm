package re.kaguya.egmv2.comment.exception;

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
    public JsonResult logError(MethodArgumentNotValidException ex) {
        log.error("logerro:" + ex.getMessage());
        return new JsonResult(StatusCode.VALIDATED_ERROR, "标题不能为空... ... 等等");
    }

    @ExceptionHandler
    public JsonResult selectError(MethodArgumentTypeMismatchException ex) {
        log.error("select:" + ex.getMessage());
        return new JsonResult(StatusCode.VALIDATED_ERROR, "文章id必须在1-100之间");
    }
}
