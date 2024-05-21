package re.kaguya._weibo_kaguya.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult {
    private Integer state;
    private String message;
    private Object data;

    public JsonResult(StatusCode statusCode) {
        this.state = statusCode.getState();
        this.message = statusCode.getMessage();
    }

    public JsonResult(StatusCode statusCode, Object data){
        this.state = statusCode.getState();
        this.message = statusCode.getMessage();
        this.data = data;
    }

    public static JsonResult ok(Object data){
        return new JsonResult(StatusCode.OPERATION_SUCCESS, data);
    }

    public static JsonResult ok(){
        return ok(null);
    }
}
