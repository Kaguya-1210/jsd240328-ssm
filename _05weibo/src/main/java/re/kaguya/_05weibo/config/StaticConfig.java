package re.kaguya._05weibo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 不是，我真他妈服了，为什么我其他项目可以通过url访问网站，为毛这个项目不行啊，气死我了操，有人有人帮我看看问题
 */
@Configuration
public class StaticConfig extends WebMvcConfigurationSupport {
    //    静态资源加载设置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}