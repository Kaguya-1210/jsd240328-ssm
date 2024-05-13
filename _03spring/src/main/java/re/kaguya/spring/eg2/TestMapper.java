package re.kaguya.spring.eg2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMapper {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext("re.kaguya.spring.eg2");
        CommentMapper bean = appContext.getBean(CommentMapper.class);
        System.out.println(bean);
    }
}
