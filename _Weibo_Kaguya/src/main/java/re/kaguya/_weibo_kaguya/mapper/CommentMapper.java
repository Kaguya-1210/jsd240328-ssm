package re.kaguya._weibo_kaguya.mapper;

import org.hibernate.validator.constraints.Range;
import re.kaguya._weibo_kaguya.pojo.entity.Comment;
import re.kaguya._weibo_kaguya.pojo.vo.CommentVO;

import java.util.List;

public interface CommentMapper {
    /**
     * 1.发表评论功能
     * @param comment 实体类型
     * @return 影响的行数
     */
    int insert(Comment comment);

    /**
     * 2.获取评论列表功能
     *
     * @param id 微博ID
     * @return List集合
     */
    List<CommentVO> selectByWeiboId(@Range(min = 200, max = 500) Integer id);
}
