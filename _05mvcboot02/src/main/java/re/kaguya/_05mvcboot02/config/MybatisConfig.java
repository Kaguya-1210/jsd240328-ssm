package re.kaguya._05mvcboot02.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("re.kaguya._05mvcboot02.mapper")
public class MybatisConfig {

}
