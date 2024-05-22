package re.kaguya._06interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "done.";
    }

    @GetMapping("/reg")
    public String reg() {
        return "done.";
    }
}
