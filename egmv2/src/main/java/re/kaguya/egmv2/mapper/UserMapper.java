package re.kaguya.egmv2.mapper;

import org.apache.ibatis.annotations.Param;
import re.kaguya.egmv2.pojo.entity.Article;
import re.kaguya.egmv2.pojo.vo.ArticleVO;
import re.kaguya.egmv2.pojo.vo.UserVo;

public interface UserMapper {

    UserVo selectUser(@Param("username") String username,
                      @Param("password") String password);

    void sendContent(Article article);

    ArticleVO selectArticle(Long id);
}
