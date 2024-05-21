package re.kaguya._05mvcboot3.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusCode {
    // 所有的实例都放在最上面;
    NOT_LOGIN(10400, "未登录"),
    OPERATION_SUCCESS(10100, "操作成功"),
    OPERATION_FAILED(10200, "操作失败"),
    USERNAME_PASSWORD_ERROR(10300,"用户名或密码错误"),
    VALIDATED_ERROR(10500, "参数校验失败");

    private Integer state;
    private String message;
}