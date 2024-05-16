package re.kaguya._05mvcboot02.pojo.mapper;


import re.kaguya._05mvcboot02.pojo.pojo.entity.User;
import re.kaguya._05mvcboot02.pojo.pojo.vo.UserListVo;

import java.util.List;


public interface UserMapper {
    /**
     * 1.插入数据接口
     * @param user 实体类对象
     * @return 影响的行数
     */
    int insertUser(User user);

    List<UserListVo> selectUserList();

    int deleteUser(Integer id);

    void updateUser(User user);
}
