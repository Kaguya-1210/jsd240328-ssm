package re.kaguya._04mybatis.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVo3 {
    private Long id;
    private String content;
    private Date created;
}
