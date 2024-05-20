package re.kaguya._05weibo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import re.kaguya._05weibo.mapper.CommentMapper;
import re.kaguya._05weibo.pojo.dto.CommentDTO;
import re.kaguya._05weibo.pojo.entity.Comment;
import re.kaguya._05weibo.pojo.vo.CommentVo;
import re.kaguya._05weibo.pojo.vo.UserVo;
import re.kaguya._05weibo.response.JsonResult;
import re.kaguya._05weibo.response.StatusCode;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/comment/")
public class CommentController {

    @Autowired
    private CommentMapper commentsMapper;
    @PostMapping("insert")
    JsonResult insert(@RequestBody CommentDTO commentDTO, HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        if (userVo == null) {
            return new JsonResult(StatusCode.OPERATION_FAILED);
        }
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        comment.setUserId(userVo.getId());
        comment.setCreated(new Date());
        commentsMapper.insert(comment);
        return new JsonResult(StatusCode.LOGIN_SUCCESS);
    }
    @GetMapping("selectByWeiboId")
    JsonResult selectComments(Integer id) {
        return JsonResult.ok(commentsMapper.selectByWeiboId(id));
    }

}
