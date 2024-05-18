package re.kaguya._05weibo.mapper;

import re.kaguya._05weibo.pojo.dto.CommentDTO;
import re.kaguya._05weibo.pojo.entity.Comment;
import re.kaguya._05weibo.pojo.vo.CommentVo;

import java.util.List;

public interface CommentMapper {
    int insert(Comment comment);

    List<CommentVo> selectByWeiboId(Integer id);
}
