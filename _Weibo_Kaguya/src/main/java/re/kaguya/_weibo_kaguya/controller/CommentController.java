package re.kaguya._weibo_kaguya.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import re.kaguya._weibo_kaguya.common.response.JsonResult;
import re.kaguya._weibo_kaguya.common.response.StatusCode;
import re.kaguya._weibo_kaguya.mapper.CommentMapper;
import re.kaguya._weibo_kaguya.pojo.dto.CommentDTO;
import re.kaguya._weibo_kaguya.pojo.entity.Comment;
import re.kaguya._weibo_kaguya.pojo.vo.CommentVO;
import re.kaguya._weibo_kaguya.pojo.vo.UserVo;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/comment")
@Slf4j
@Tag(name = "评论模块", description = "管理微博内容评论之间的事情..")
public class CommentController {
    @Autowired
    private CommentMapper commentsMapper;
    @Operation(summary = "发表评论")
    @PostMapping("/insert")
    public JsonResult insert(@Validated @RequestBody CommentDTO commentDTO, HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        if (userVo != null) {
            Comment comment = new Comment();
            BeanUtils.copyProperties(commentDTO, comment);
            comment.setCreated(new Date());
            comment.setUserId(userVo.getId());
            commentsMapper.insert(comment);
            return new JsonResult(StatusCode.OPERATION_SUCCESS, comment);
        }
        return new JsonResult(StatusCode.NOT_LOGIN);
    }
    @Operation(summary = "获取文章评论列表")
    @GetMapping("selectByWeiboId")
    public JsonResult selectByWeiboId(Integer id) {
        System.out.println("id = " + id);
        List<CommentVO> commentVOS = commentsMapper.selectByWeiboId(id);
        return JsonResult.ok(commentVOS);
    }
}
