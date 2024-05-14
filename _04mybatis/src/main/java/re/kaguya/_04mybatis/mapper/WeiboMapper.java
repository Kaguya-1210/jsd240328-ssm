package re.kaguya._04mybatis.mapper;

import re.kaguya._04mybatis.pojo.entity.Weibo;
import re.kaguya._04mybatis.pojo.vo.WeiboVO1;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface WeiboMapper {
    //@Insert("INSERT INTO weibo(content,created,user_id) VALUES (#{content},#{created},#{userId})")
    void insertWeibo(Weibo weibo);

    //@Insert("DELETE FROM weibo WHERE id=#{id}")
    void deleteWeibo(Long id);

    //@Update("UPDATE weibo SET content=#{content},created=#{created},user_id=#{userId} WHERE id=#{id}")
    void updateWeibo(Weibo weibo);

    //@Select("SELECT id,content,created,user_id userId FROM weibo WHERE id = #{wid}")
    List<Weibo> selectWeibo(Long wid);

    //@Select("SELECT id,content,created,user_id userId FROM weibo")
    List<Weibo> selectAllWeibo();

    //@Select("SELECT content,created userId FROM weibo where id=#{wid}")
    List<WeiboVO1> selectWeiboTest(Long wid);

    int dynamicUpdateWeibo(Weibo weibo);

    int deleteByIds(Long[] id);


}









