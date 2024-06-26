package re.kaguya._weibo_kaguya.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private Long id;
    private String content;
    private Date created;
    private Long userId;
    private Long weiboId;
}
