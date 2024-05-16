package re.kaguya._05mvcboot01.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import re.kaguya._05mvcboot01.pojo.UserRegDTO;

@Controller
public class UserController {
    @RequestMapping("/login")
    @ResponseBody
    public String login() {
        return "done";
    }

    @PostMapping("/reg")
    @ResponseBody
    public String reg(String username, String password) {
        return username + "," + password;
    }

    @RequestMapping("/regParam1")
    @ResponseBody
    public String regParam1(HttpServletRequest request) {
        return request.getParameter("username") + "," + request.getParameter("password");
    }
    @RequestMapping("/regParam2")
    @ResponseBody
    public String regParam2(HttpServletRequest request) {
        return request.getParameter("username") + "," + request.getParameter("password");
    }

    @RequestMapping("/regParam3")
    @ResponseBody
    public String regParam2(UserRegDTO userRegDTO) {
        return userRegDTO.toString();
    }
}

