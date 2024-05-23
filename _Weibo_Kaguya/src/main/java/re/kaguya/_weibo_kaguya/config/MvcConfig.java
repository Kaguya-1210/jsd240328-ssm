package re.kaguya._weibo_kaguya.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import re.kaguya._weibo_kaguya.interceptors.MyInterceptors;
import re.kaguya._weibo_kaguya.interceptors.UserLoginInterceptors;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptors())
                .addPathPatterns("/v1/weibo/**")
                .addPathPatterns("/v1/comment")
                .excludePathPatterns("v1/comment/selectByWeiboId");
    }
}
