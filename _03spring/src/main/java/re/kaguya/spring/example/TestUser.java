package re.kaguya.spring.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("re.kaguya.spring.example");
        User user = ctx.getBean(User.class);
        user.run();
    }
}
