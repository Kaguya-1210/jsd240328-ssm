package re.kaguya._06interceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import re.kaguya._06interceptor.interceptors.MyInterceptors;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有
        //registry.addInterceptor(new MyInterceptors());
        //拦截指定
        //registry.addInterceptor(new MyInterceptors())
        //.addPathPatterns("/users/login");
//        拦截指定模块请求
//        registry.addInterceptor(new MyInterceptors())
//                .addPathPatterns();
        registry.addInterceptor(new MyInterceptors())
                .addPathPatterns("users/**")
                .excludePathPatterns("/users/login");
    }
}
