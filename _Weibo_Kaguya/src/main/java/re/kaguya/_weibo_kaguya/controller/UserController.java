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
import re.kaguya._weibo_kaguya.mapper.UserMapper;
import re.kaguya._weibo_kaguya.pojo.dto.userLoginDTO;
import re.kaguya._weibo_kaguya.pojo.dto.userRegDTO;
import re.kaguya._weibo_kaguya.pojo.entity.User;
import re.kaguya._weibo_kaguya.pojo.vo.UserVo;

import java.util.Date;

@RestController
@RequestMapping("v1/users/")
@Slf4j
@Tag(name = "用户模块", description = "管理用户相关操做")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/reg")
    @Operation(summary = "注册")
    public JsonResult reg(@Validated @RequestBody userRegDTO UserDTO) {
        log.debug(UserDTO.toString());
        UserVo userVo = userMapper.selectByUsername(UserDTO.getUsername());
        if (userVo != null) {
            return new JsonResult(StatusCode.USERNAME_ALREADY_EXISTS);
        }
        User user = new User();
        BeanUtils.copyProperties(UserDTO, user);
        user.setCreated(new Date());
        userMapper.insert(user);
        return new JsonResult(StatusCode.OPERATION_SUCCESS, user);
    }

    @PostMapping("/login")
    @Operation(summary = "登录")
    public JsonResult login(@RequestBody @Validated userLoginDTO userLoginDTO, HttpSession session) {
        UserVo userVo = userMapper.selectByUsername(userLoginDTO.getUsername());
        if (userVo != null) {
            if (userVo.getPassword().equals(userLoginDTO.getPassword())) {
                session.setAttribute("user", userVo);
                return new JsonResult(StatusCode.LOGIN_SUCCESS, userVo);
            }
            return new JsonResult(StatusCode.VALIDATED_ERROR, "用户名或密码错误");
        }
        return new JsonResult(StatusCode.VALIDATED_ERROR, "用户名或密码错误");
    }

    @GetMapping("/currentUser")
    @Operation(summary = "获取当前用户")
    public JsonResult getCurrentUser(HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        if (userVo == null) {
            return new JsonResult(StatusCode.NOT_LOGIN);
        }
        return JsonResult.ok();
    }

    @GetMapping("/logout")
    @Operation(summary = "退出登录")
    public JsonResult logout(HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        if (userVo != null) {
            session.removeAttribute("user");
            return JsonResult.ok();
        }
        return new JsonResult(StatusCode.NOT_LOGIN);
    }
}
