package re.kaguya._05weibo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import re.kaguya._05weibo.mapper.WeiboMapper;
import re.kaguya._05weibo.pojo.dto.WeiboDTO;
import re.kaguya._05weibo.pojo.entity.Weibo;
import re.kaguya._05weibo.pojo.vo.UserVo;
import re.kaguya._05weibo.pojo.vo.WeiboDetailVO;
import re.kaguya._05weibo.pojo.vo.WeiboIndexVO;
import re.kaguya._05weibo.utils.Result;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/weibo")
public class WeiboController {

    @Autowired
    private WeiboMapper weiboMapper;

    @PostMapping("/insert")
    public Result insert(@RequestBody WeiboDTO weiboDTO, HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        Result result = new Result();
        if (userVo == null) {
            result.setCode(2);
            result.setMessage("未登录");
            return result;
        }
        Weibo weibo = new Weibo();
        BeanUtils.copyProperties(weiboDTO, weibo);
        weibo.setCreated(new Date());
        weibo.setUserId(userVo.getId());
        System.out.println(weiboDTO + "///" + weibo);
        weiboMapper.insert(weibo);
        result.setCode(1);
        result.setMessage("发布成功");
        result.setData(weibo);
        return result;
    }

    @GetMapping("/selectIndex")
    public Result<List<WeiboIndexVO>> selectWeibo() {
        return Result.success(weiboMapper.select());
    }
    @GetMapping("selectById")
    public Result<WeiboDetailVO> selectById(Integer id) {
        return Result.success(weiboMapper.selectWeibo(id));
    }
}

