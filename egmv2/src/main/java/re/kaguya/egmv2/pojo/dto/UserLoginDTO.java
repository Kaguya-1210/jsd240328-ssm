package re.kaguya.egmv2.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginDTO {
    @Schema(description = "用户名")
    @NotBlank
    private String username;
    @Schema(description = "密码")
    @NotBlank
    private String password;
}
