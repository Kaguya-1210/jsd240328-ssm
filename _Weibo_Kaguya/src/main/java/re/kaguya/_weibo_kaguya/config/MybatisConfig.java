package re.kaguya._weibo_kaguya.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("re.kaguya._weibo_kaguya.mapper")
public class MybatisConfig {
}