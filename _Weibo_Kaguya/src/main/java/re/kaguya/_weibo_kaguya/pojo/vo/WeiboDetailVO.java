package re.kaguya._weibo_kaguya.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 微博详情页VO
 */
@Data
public class WeiboDetailVO {
    // 微博ID、微博内容、用户昵称、发布时间
    @Schema(description =  "微博ID")
    private Long id;
    @Schema(description = "微博内容")
    private String content;
    @Schema(description = "用户昵称")
    private String nickname;
    /*
        JsonFormat注解：
        1. pattern参数：日期时间格式; 小大小,大小小
           1.1 格式1：yyyy-MM-dd HH:mm:ss
           1.2 格式2：yyyy/MM/dd HH:mm:ss
           1.3 格式3：yyyy年MM月dd日 HH时mm分ss秒
        2.timezone参数：时区，默认是UTC
           2.1 时区：Asia/Shanghai
           2.2 时区：GMT+8
     */
    @Schema(description =  "微博发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date created;
}









