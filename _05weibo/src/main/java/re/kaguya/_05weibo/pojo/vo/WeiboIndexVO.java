package re.kaguya._05weibo.pojo.vo;

import lombok.Data;

@Data
public class WeiboIndexVO {
    // 微博ID、微博内容、用户昵称
    private Long id;
    private String content;
    private String nickname;
}
