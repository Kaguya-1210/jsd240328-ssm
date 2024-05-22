package re.kaguya._weibo_kaguya.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 微博首页列表展示VO
 */
@Data
public class WeiboIndexVO {
    // 微博ID、微博内容、用户昵称
    @Schema(description = "微博ID")
    private Long id;
    @Schema(description ="微博内容")
    private String content;
    @Schema(description = "用户昵称")
    private String nickname;
}








