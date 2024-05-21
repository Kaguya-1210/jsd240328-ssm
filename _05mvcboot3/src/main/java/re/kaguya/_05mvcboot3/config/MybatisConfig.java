package re.kaguya._05mvcboot3.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("re.kaguya._05mvcboot3.mapper")
public class MybatisConfig {
}