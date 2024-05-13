package re.kaguya.spring.dibase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("re.kaguya.spring.dibase");
        UserService bean = context.getBean(UserService.class);
        System.out.println(bean);

    }
}
