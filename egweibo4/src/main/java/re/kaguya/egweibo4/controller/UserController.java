package re.kaguya.egweibo4.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import re.kaguya.egweibo4.response.JsonResult;

@RestController
@RequestMapping("/v1/user/")
@Tag(name = "用户容器", description = "管理用户")
@Slf4j
public class UserController {
    @GetMapping("/select")
    @Operation(summary = "查询用户",description = "根据id查询用户")
    public JsonResult select(Integer id) {
        log.debug("id=" + id);
        return JsonResult.ok(id);
    }
}
