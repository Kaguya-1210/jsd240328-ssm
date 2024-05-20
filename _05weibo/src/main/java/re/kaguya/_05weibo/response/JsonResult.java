package re.kaguya._05weibo.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//响应结果
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JsonResult {
    private Integer state;//业务状态码  0-成功  1-失败
    private String message;//提示信息
    private Object data;//响应数据

    //快速返回操作成功响应结果(带响应数据)
    //
    public JsonResult(StatusCode stateCode) {
        this.state = stateCode.getState();
        this.message = stateCode.getMessage();
    }
    public JsonResult(StatusCode stateCode,Object data) {
        this.state = stateCode.getState();
        this.message = stateCode.getMessage();
        this.data = data;
    }

    public static JsonResult ok(Object data) {
        return new JsonResult(StatusCode.OPERATION_SUCCESS, data);
    }
    public static JsonResult ok() {
        return ok(null);
    }
}
