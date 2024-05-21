package re.kaguya._weibo_kaguya.mapper;

import re.kaguya._weibo_kaguya.pojo.entity.User;
import re.kaguya._weibo_kaguya.pojo.vo.UserVo;

public interface UserMapper {

    //搜索用户
    UserVo selectByUsername(String username);

    //注册用户
    void insert(User user);
}
