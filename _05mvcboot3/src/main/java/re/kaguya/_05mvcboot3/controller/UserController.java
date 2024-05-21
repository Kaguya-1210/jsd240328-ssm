package re.kaguya._05mvcboot3.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import re.kaguya._05mvcboot3.common.response.JsonResult;
import re.kaguya._05mvcboot3.common.response.StatusCode;
import re.kaguya._05mvcboot3.mapper.UserMapper;
import re.kaguya._05mvcboot3.pojo.dto.UserArticleDTO;
import re.kaguya._05mvcboot3.pojo.dto.UserLoginDTO;
import re.kaguya._05mvcboot3.pojo.entity.Article;
import re.kaguya._05mvcboot3.pojo.vo.ArticleVO;
import re.kaguya._05mvcboot3.pojo.vo.UserVo;


@RestController
@RequestMapping("/v1/users")
@Tag(name = "用户模块", description = "管理用户相关的操作")
@Slf4j
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    @Operation(summary = "登录")
    public JsonResult login(@Validated @RequestBody UserLoginDTO userLoginDTO, HttpSession session) {
        UserVo userVo = userMapper.selectUser(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        if (userVo != null) {
            if (userVo.getPassword().equals(userLoginDTO.getPassword())) {
                session.setAttribute("user", userVo);
                return new JsonResult(StatusCode.OPERATION_SUCCESS, userVo);
            }
            return new JsonResult(StatusCode.USERNAME_PASSWORD_ERROR);
        }
        return new JsonResult(StatusCode.USERNAME_PASSWORD_ERROR);
    }

    @PostMapping("/article")
    @Operation(summary = "发表文章")
    public JsonResult sendArticle(@Validated @RequestBody UserArticleDTO userArticleDTO, HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        if (userVo != null) {
            Article article = new Article();
            BeanUtils.copyProperties(userArticleDTO, article);
            article.setUserId(userVo.getId());
            userMapper.sendContent(article);
            return new JsonResult(StatusCode.OPERATION_SUCCESS, userArticleDTO.toString());
        }
        return new JsonResult(StatusCode.NOT_LOGIN);
    }

    @GetMapping("/selectByArticleId")
    @Operation(summary = "查询指定文章")
    public JsonResult selectByArticle(@Range(min = 1, max = 100) @RequestParam Long id, HttpSession session) {
        if (id < 0) {
            return new JsonResult(StatusCode.VALIDATED_ERROR, "id不能小于0");
        }
        UserVo userVo = (UserVo) session.getAttribute("user");
        if (userVo != null) {
            ArticleVO articleVO = userMapper.selectArticle(id);
            return new JsonResult(StatusCode.OPERATION_SUCCESS, articleVO);
        }
        return new JsonResult(StatusCode.NOT_LOGIN);
    }
}
