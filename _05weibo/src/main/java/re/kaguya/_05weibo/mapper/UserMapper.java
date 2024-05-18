package re.kaguya._05weibo.mapper;

import re.kaguya._05weibo.pojo.entity.User;
import re.kaguya._05weibo.pojo.vo.UserVo;

public interface UserMapper {
    /**
     * 1.注册功能: 查询接口
     * SELECT id FROM user WHERE username=?
     * 2.关于查询字段的问题
     * 2.1 注册功能: id;
     * 2.2 登录功能: password;
     * 方案: SELECT password FROM user WHERE username=?  然后比较密码
     */
    UserVo selectByUsername(String username);

    int insert(User user);
}
