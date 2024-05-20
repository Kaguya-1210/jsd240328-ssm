package re.kaguya._05weibo.pojo.dto;

import lombok.Data;

import java.util.StringTokenizer;

/**
 * 注册功能DTO类
 */
@Data
public class UserRegDTO {
    // 用户名,密码,昵称
    private String username;
    private String password;
    private String nickname;
}
