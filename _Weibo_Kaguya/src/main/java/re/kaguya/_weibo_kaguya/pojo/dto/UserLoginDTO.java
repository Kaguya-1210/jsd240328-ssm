package re.kaguya._weibo_kaguya.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginDTO {
    @Schema(description = "用户名", required = true)
    @NotBlank
    private String username;
    @Schema(description = "密码", required = true)
    @NotBlank
    private String password;
}
