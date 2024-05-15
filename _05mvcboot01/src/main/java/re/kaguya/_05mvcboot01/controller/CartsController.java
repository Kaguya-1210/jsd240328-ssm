package re.kaguya._05mvcboot01.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CartsController {

    @RequestMapping("/v1/carts/add")
    @ResponseBody
    public String addProduct() {
        return "添加购物车成功";
    }
}
