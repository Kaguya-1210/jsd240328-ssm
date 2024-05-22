package re.kaguya._weibo_kaguya.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import re.kaguya._weibo_kaguya.common.response.JsonResult;
import re.kaguya._weibo_kaguya.common.response.StatusCode;
import re.kaguya._weibo_kaguya.mapper.WeiboMapper;
import re.kaguya._weibo_kaguya.pojo.dto.WeiboDTO;
import re.kaguya._weibo_kaguya.pojo.entity.Weibo;
import re.kaguya._weibo_kaguya.pojo.vo.UserVo;
import re.kaguya._weibo_kaguya.pojo.vo.WeiboDetailVO;

import java.util.Date;

@RestController
@RequestMapping("/v1/weibo")
@Slf4j
@Tag(name = "微博模块", description = "管理微博之间的事情..")
public class WeiboController {
    @Autowired
    private WeiboMapper weiboMapper;

    @Operation(summary = "发布微博")
    @PostMapping("/insert")
    public JsonResult insert(@Validated @RequestBody WeiboDTO weiboDTO, HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        if (userVo != null) {
            Weibo weibo = new Weibo();
            BeanUtils.copyProperties(weiboDTO, weibo);
            weibo.setCreated(new Date());
            weibo.setUserId(userVo.getId());
            weiboMapper.insert(weibo);
            return new JsonResult(StatusCode.OPERATION_SUCCESS, weibo);
        }
        return new JsonResult(StatusCode.NOT_LOGIN);
    }

    @Operation(summary = "获取微博列表")
    @GetMapping("/selectIndex")
    public JsonResult selectIndex() {
        return new JsonResult(StatusCode.OPERATION_SUCCESS, weiboMapper.selectIndex());
    }

    @Operation(summary = "获取微博详细")
    @GetMapping("/selectById")
    public JsonResult selectById(@Range(min = 200, max = 300, message = "ID值必须在200~300之间") @RequestParam Integer id){
        if (id < 0){
            throw new IllegalArgumentException("ID值不能小于0");
        }

        // username参数为了演示Knife4j的注解,没有其他作用
        WeiboDetailVO weiboDetailVO = weiboMapper.selectById(id);

        return JsonResult.ok(weiboDetailVO);
    }
}
