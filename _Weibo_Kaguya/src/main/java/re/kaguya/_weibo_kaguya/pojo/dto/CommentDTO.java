package re.kaguya._weibo_kaguya.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * 发表评论的DTO类
 */
@Data
public class CommentDTO {
    // 评论内容,微博ID
    @Schema(description =  "评论内容", required = true)
    @NotBlank
    private String content;
    @Schema(description = "微博ID", required = true)
    @Range(min = 200, max = 300, message = "ID值必须在200~300之间")
    private Long weiboId;
}







