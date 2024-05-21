package re.kaguya.egmv2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import re.kaguya._05mvcboot3.common.response.JsonResult;
import re.kaguya._05mvcboot3.common.response.StatusCode;
import re.kaguya.egmv2.mapper.UserMapper;
import re.kaguya.egmv2.pojo.dto.UserArticleDTO;
import re.kaguya.egmv2.pojo.dto.UserLoginDTO;
import re.kaguya.egmv2.pojo.entity.Article;
import re.kaguya.egmv2.pojo.vo.ArticleVO;
import re.kaguya.egmv2.pojo.vo.UserVo;

@RestController
@RequestMapping("/v1/users/")
@Tag(name = "用户模块")
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


    /*
请求体数据：UserArticleDTO
文章标题title：标题不能为空白，长度为1-20
文章内容content：内容不能为空白，长度为10-500
返回响应：JsonResult
未登录：{"state": 10400, "message": "未登录", "data": null}
发布成功：{"state": 10100, "message": "操作成功", "data": null}
数据异常：{"state": 10500, "message": "参数校验失败", "data": "标题不能为空... ... 等等"
     */
    @PostMapping("/article")
    @Operation(summary = "发布文章")
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

    //    3.3 查询指定文章功能
//    请求地址：
//            /v1/users/selectByArticleId
//    请求方法：GET
//    查询参数：文章id 【要求在1-100之间】
//    返回响应：
//    查询成功：ArticleVO 【文章标题title、文章内容content、用户昵称nickname】
//    {"state": 10100, "message": "操作成功", "data": ArticleVO}
//    id数据无效：{"state": 10500, "message": "参数校验失败", "data": "文章id必须在1-100之
//        间"
    @GetMapping("selectByArticleId")
    @Operation(summary = "查询指定文章")
    public JsonResult selectByArticle(@Validated @RequestParam @Range(min = 1, max = 100) Long id, HttpSession session) {
        if (id < 0) {
            return new JsonResult(StatusCode.VALIDATED_ERROR, "id not < 0");
        }
        UserVo userVo = (UserVo) session.getAttribute("user");
        if (userVo != null) {
            ArticleVO articleVO = userMapper.selectArticle(id);
            return new JsonResult(StatusCode.OPERATION_SUCCESS, articleVO);
        }
        return new JsonResult(StatusCode.NOT_LOGIN);
    }
}
