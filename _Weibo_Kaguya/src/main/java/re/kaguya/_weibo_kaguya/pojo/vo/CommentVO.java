package re.kaguya._weibo_kaguya.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 评论列表VO
 */
@Data
public class CommentVO {
    //评论ID、评论内容、评论时间、用户昵称
    @Schema(description =  "评论ID")
    private Long id;
    @Schema(description = "评论内容")
    private String content;
    @Schema(description =  "评论时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created;
    @Schema(description = "用户昵称")
    private String nickname;
}







