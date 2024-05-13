package re.kaguya.spring.eg1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class tESTpROUDUCT {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext("re.kaguya.spring.eg1");
        Product bean = appContext.getBean(Product.class);
        System.out.println(bean.toString());

    }
}
