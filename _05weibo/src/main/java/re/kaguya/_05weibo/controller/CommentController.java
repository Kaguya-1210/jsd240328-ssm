package re.kaguya._05weibo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import re.kaguya._05weibo.mapper.CommentMapper;
import re.kaguya._05weibo.pojo.dto.CommentDTO;
import re.kaguya._05weibo.pojo.entity.Comment;
import re.kaguya._05weibo.pojo.entity.User;
import re.kaguya._05weibo.pojo.vo.CommentVo;
import re.kaguya._05weibo.pojo.vo.UserVo;
import re.kaguya._05weibo.utils.Result;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/comment/")
public class CommentController {

    @Autowired
    private CommentMapper commentsMapper;
    @PostMapping("insert")
    Result<Comment> insert(@RequestBody CommentDTO commentDTO, HttpSession session) {
        Result result = new Result();
        UserVo userVo = (UserVo) session.getAttribute("user");
        if (userVo == null) {
            result.setCode(2);
            result.setMessage("未登录");
            return result;
        }
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        comment.setUserId(userVo.getId());
        comment.setCreated(new Date());
        commentsMapper.insert(comment);
        result.setData(comment);
        result.setCode(1);
        result.setMessage("发送成功");
        return result;
    }

    @GetMapping("selectByWeiboId")
    Result<List<CommentVo>> selectComments(Integer id) {
        return Result.success(commentsMapper.selectByWeiboId(id));
    }

}
