package re.kaguya._05weibo.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import re.kaguya._05weibo.mapper.UserMapper;
import re.kaguya._05weibo.pojo.dto.UserLoginDto;
import re.kaguya._05weibo.pojo.dto.UserRegDTO;
import re.kaguya._05weibo.pojo.entity.User;
import re.kaguya._05weibo.pojo.vo.UserVo;
import re.kaguya._05weibo.utils.Result;

import java.util.Date;

@RestController
@RequestMapping("/v1/users/")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("reg")
    Result<User> reg(@RequestBody UserRegDTO userRegDTO) {
        /*
            梳理业务逻辑,确定数据库接口;
            1.获取客户端传递的数据;
            2.校验数据合法性[此处暂时不校验];
            3.确定用户名是否已存在[SELECT查询接口];
              3.1 如果已存在,return 2;
              3.2 如果不存在,插入数据[INSERT插入接口], return 1;
         */
        Result result = new Result();
        UserVo userVo = userMapper.selectByUsername(userRegDTO.getUsername());
        if (userVo != null) {
            result.setCode(2);
            return result.error("用户名被占用");
        }
        User user = new User();
        user.setNickname(userRegDTO.getNickname());
        user.setPassword(userRegDTO.getPassword());
        user.setUsername(userRegDTO.getUsername());
        user.setCreated(new Date());
        userMapper.insert(user);
        System.out.println("userRegDTO = " + userRegDTO);
        result.setCode(1);
        result.setMessage("注册成功");
        result.setData(user);
        return result;
    }


    @PostMapping("login")
    public Result login(@RequestBody UserLoginDto userLoginDto, HttpSession session) {
        Result result = new Result();
        UserVo userVo = userMapper.selectByUsername(userLoginDto.getUsername());
        if (userVo != null) {
            if (userVo.getPassword().equals(userLoginDto.getPassword())) {
                result.setCode(1);
                result.setMessage("登录成功");
                session.setAttribute("user", userVo);
                result.setData(userLoginDto);
                return result;
            }
            result.setCode(2);
            return result.error("用户名或密码错误");
        }
        result.setCode(2);
        return result.error("用户名不存在");
    }

    @GetMapping("/currentUser")
    public Result getCurrentUser(HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        return Result.success(userVo);
    }

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }
}











