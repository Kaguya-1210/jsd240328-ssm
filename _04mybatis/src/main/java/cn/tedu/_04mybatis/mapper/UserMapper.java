package cn.tedu._04mybatis.mapper;

import cn.tedu._04mybatis.pojo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper注解：
 * 1.MyBatis框架的注解;
 * 2.作用：标识当前接口是一个Mapper接口,可以为该接口创建实现类;
 */
@Mapper
public interface UserMapper {
    //@Insert("INSERT INTO user(username,password,nickname,created) VALUES (#{username},#{password},#{nickname},#{created})")

    void insertUser(User user);
}








