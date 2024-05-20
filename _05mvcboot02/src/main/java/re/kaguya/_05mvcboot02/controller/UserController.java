package re.kaguya._05mvcboot02.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import re.kaguya._05mvcboot02.mapper.UserMapper;
import re.kaguya._05mvcboot02.pojo.dto.UserInsertDTO;
import re.kaguya._05mvcboot02.pojo.entity.User;
import re.kaguya._05mvcboot02.pojo.vo.UserListVo;
import re.kaguya._05mvcboot02.utils.Result;

import java.util.Date;
import java.util.List;

@Tag(name = "用户管理",description = "用户管理相关操作")
@Slf4j
@RestController
@RequestMapping("/v1/users/")
public class UserController {

    //自动装配
    @Autowired
    private UserMapper userMapper;

    @Operation(summary = "注册", description = "就是注册")
    @PostMapping("insert")
    public String insert(UserInsertDTO userInsertDTO) {
        /*
            梳理业务逻辑,确定接口-假如说是注册功能:
            1.获取用户输入的数据;
            2.校验用户输入的数据[暂时不做];
            3.校验用户名是否被占用[SELECT接口];
              3.1 如果被占用,提示用户名被占用;
              3.2 未被占用,插入数据[INSERT接口],返回响应.
         */
        User user = new User();
        //复制属性
        BeanUtils.copyProperties(userInsertDTO, user);
        user.setCreated(new Date());
        //调用接口方法
        userMapper.insertUser(user);

        return "添加成功";
    }

    @Operation(summary = "获取全部用户")
    @GetMapping("userList")
    public List<UserListVo> setUserList() {
        return userMapper.selectUserList();
    }

    @Operation(summary = "删除用户", description = "通过id删除")
    @PostMapping("delete")
    public Result<String> deleteUser(Integer id) {
        userMapper.deleteUser(id);
        return Result.success("删除成功");
    }

    @Operation(summary = "更新用户", description = "需要User实体类的参数")
    @PostMapping("update")
    public Result<String> updateUser(User user) {
        userMapper.updateUser(user);
        return Result.success(user.toString());
    }
}
