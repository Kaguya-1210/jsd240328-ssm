package re.kaguya._05weibo.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import re.kaguya._05weibo.mapper.UserMapper;
import re.kaguya._05weibo.pojo.dto.UserLoginDto;
import re.kaguya._05weibo.pojo.dto.UserRegDTO;
import re.kaguya._05weibo.pojo.entity.User;
import re.kaguya._05weibo.pojo.vo.UserVo;
import re.kaguya._05weibo.response.JsonResult;
import re.kaguya._05weibo.response.StatusCode;

import java.util.Date;

@RestController
@RequestMapping("/v1/users/")
@Tag(name = "用户管理", description = "管理用户相关操作")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("reg")
    @Operation(summary = "注册用户")
    JsonResult reg(@Parameter(description = "用户id", required = true) @RequestBody UserRegDTO userRegDTO) {
        /*
            梳理业务逻辑,确定数据库接口;
            1.获取客户端传递的数据;
            2.校验数据合法性[此处暂时不校验];
            3.确定用户名是否已存在[SELECT查询接口];
              3.1 如果已存在,return 2;
              3.2 如果不存在,插入数据[INSERT插入接口], return 1;
         */
        UserVo userVo = userMapper.selectByUsername(userRegDTO.getUsername());
        if (userVo != null) {
            return new JsonResult(StatusCode.USERNAME_ALREADY_EXISTS);
        }
        User user = new User();
        user.setNickname(userRegDTO.getNickname());
        user.setPassword(userRegDTO.getPassword());
        user.setUsername(userRegDTO.getUsername());
        user.setCreated(new Date());
        userMapper.insert(user);
        System.out.println("userRegDTO = " + userRegDTO);
        return JsonResult.ok();
    }


    @PostMapping("login")
    public JsonResult login(@RequestBody UserLoginDto userLoginDto, HttpSession session) {
        UserVo userVo = userMapper.selectByUsername(userLoginDto.getUsername());
        if (userVo != null) {
            if (userVo.getPassword().equals(userLoginDto.getPassword())) {
                session.setAttribute("user", userVo);
                return new JsonResult(StatusCode.LOGIN_SUCCESS, userLoginDto);
            }
            return new JsonResult(StatusCode.PASSWORD_ERROR);
        }
        return new JsonResult(StatusCode.USERNAME_ERROR);
    }

    @GetMapping("/currentUser")
    public JsonResult getCurrentUser(HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        if (userVo == null) {
            return new JsonResult(StatusCode.NOT_LOGIN);
        }
        return new JsonResult(StatusCode.LOGIN_SUCCESS);
    }

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }
}











