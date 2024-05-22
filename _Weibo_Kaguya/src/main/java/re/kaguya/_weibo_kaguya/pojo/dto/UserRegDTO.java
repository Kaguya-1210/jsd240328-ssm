package re.kaguya._weibo_kaguya.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRegDTO {
    @Schema(description = "用户名",required = true)
    @NotBlank
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{1,7}|[a-zA-Z]{1,14}$", message = "用户名不能超过7个汉字或14个英文字符")
    private String username;
    @Schema(description = "密码",required = true)
    @NotBlank
    private String password;
    @NotBlank
    @Schema(description = "昵称",required = true)
    private String nickname;
}
