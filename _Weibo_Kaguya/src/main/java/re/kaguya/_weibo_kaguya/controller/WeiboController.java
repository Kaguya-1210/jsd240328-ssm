package re.kaguya._weibo_kaguya.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import re.kaguya._weibo_kaguya.mapper.WeiboMapper;

@RestController
@RequestMapping("/v1/weibo")
@Slf4j
@Tag(name = "微博模块",description = "管理微博之间的事情..")
public class WeiboController {
    @Autowired
    private WeiboMapper weiboMapper;

}
