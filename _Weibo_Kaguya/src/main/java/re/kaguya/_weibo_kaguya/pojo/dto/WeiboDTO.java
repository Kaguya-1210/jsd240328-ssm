package re.kaguya._weibo_kaguya.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class WeiboDTO {
    @Schema(description = "发布内容")
    @NotBlank
    private String content;
}
