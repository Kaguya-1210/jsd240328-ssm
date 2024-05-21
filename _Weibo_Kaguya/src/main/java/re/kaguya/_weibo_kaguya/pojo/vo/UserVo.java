package re.kaguya._weibo_kaguya.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserVo {
    @Schema(description = "用户ID")
    private Long id;
    @Schema(description = "密码", required = true)
    private String password;
    @Schema(description = "用户昵称", required = true)
    private String nickname;
}
