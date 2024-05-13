package re.kaguya._04mybatis.mapper;

import re.kaguya._04mybatis.pojo.entity.Comment;
import re.kaguya._04mybatis.pojo.vo.CommentVo1;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

   // @Insert("INSERT INTO comment(content,created,user_id,weibo_id) VALUES (#{content},#{created},#{userId},#{weiboId})")
    void insert(Comment comment);

   // @Delete("DELETE FROM comment WHERE user_id=#{uid}")
    void deleteById(Long uid);

    //@Update("UPDATE comment SET content=#{content} WHERE user_id=#{userId}")
    void updateContact(Comment comment);

   // @Select("SELECT content,user_id userId,weibo_id weiboId FROM comment WHERE id=#{wid}")
    List<CommentVo1> selectContent(Long wid);

   // @Select("SELECT content,user_id userId,weibo_id weiboId FROM comment WHERE weibo_id=#{wid}")
    List<CommentVo1> selectContent1(Long wid);


    /*
        private Long id;
    private String content;
    private Data created;
    private Long userId;
    private Long weiboId;
     */
}
