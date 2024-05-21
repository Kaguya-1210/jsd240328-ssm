package re.kaguya._05mvcboot3.mapper;

import org.apache.ibatis.annotations.Param;
import re.kaguya._05mvcboot3.pojo.dto.UserArticleDTO;
import re.kaguya._05mvcboot3.pojo.entity.Article;
import re.kaguya._05mvcboot3.pojo.vo.ArticleVO;
import re.kaguya._05mvcboot3.pojo.vo.UserVo;

public interface UserMapper {
    UserVo selectUser(@Param("username") String username,
                      @Param("password") String password);

    void sendContent(Article article);

    ArticleVO selectArticle(Long id);
}
