package re.kaguya.egmv2.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserArticleDTO {
    @Schema(description = "标题")
    @NotBlank
    @Size(min = 1, max = 20)
    private String title;
    @Schema(description = "内容")
    @NotBlank
    @Size(min = 10, max = 500)
    private String content;
}
