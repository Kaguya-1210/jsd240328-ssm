package re.kaguya._05weibo.pojo.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private String content;
    private Long weiboId;
}
