package re.kaguya.spring.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserCache {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext("re.kaguya.spring.auto");
        UserCache bean = appContext.getBean(UserCache.class);
        System.out.println(bean);
    }
}
