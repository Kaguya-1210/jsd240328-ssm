package re.kaguya._05mvcboot02.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import re.kaguya._05mvcboot02.mapper.UserMapper;
import re.kaguya._05mvcboot02.pojo.dto.UserInsertDTO;
import re.kaguya._05mvcboot02.pojo.entity.User;
import re.kaguya._05mvcboot02.pojo.vo.UserListVo;
import re.kaguya._05mvcboot02.utils.Result;

import java.util.Date;
import java.util.List;

@Tag(name = "用户管理")
@Slf4j
@RestController
@RequestMapping("/v1/users/")
public class UserController {
    //自动装配
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("insert")
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

    @RequestMapping("userList")
    public List<UserListVo> setUserList() {

        return userMapper.selectUserList();
    }

    @RequestMapping("delete")
    public Result<String> deleteUser(Integer id) {
        userMapper.deleteUser(id);
        return Result.success("删除成功");
    }

    @RequestMapping("update")
    public Result<String> updateUser(User user) {
        userMapper.updateUser(user);
        return Result.success(user.toString());
    }
}
