package re.kaguya._05weibo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("re.kaguya._05weibo.mapper")
public class MybatisConfig {
}
