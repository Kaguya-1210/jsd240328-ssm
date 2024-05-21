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
import re.kaguya._05weibo.response.JsonResult;
import re.kaguya._05weibo.response.StatusCode;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/weibo")
public class WeiboController {

    @Autowired
    private WeiboMapper weiboMapper;

    @PostMapping("/insert")
    public JsonResult insert(@RequestBody WeiboDTO weiboDTO, HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        if (userVo == null) {
            return new JsonResult(StatusCode.NOT_LOGIN);
        }
        Weibo weibo = new Weibo();
        BeanUtils.copyProperties(weiboDTO, weibo);
        weibo.setCreated(new Date());
        weibo.setUserId(userVo.getId());
        System.out.println(weiboDTO + "///" + weibo);
        weiboMapper.insert(weibo);

        return JsonResult.ok(weibo);
    }

    @GetMapping("/selectIndex")
    public JsonResult selectWeibo() {
        return JsonResult.ok(weiboMapper.select());
    }

    @GetMapping("selectById")
    public JsonResult selectById(Integer id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID值不能小于0");
        }
        return JsonResult.ok(weiboMapper.selectWeibo(id));
    }
}

