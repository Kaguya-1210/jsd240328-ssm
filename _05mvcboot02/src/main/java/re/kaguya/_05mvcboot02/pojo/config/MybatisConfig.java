package re.kaguya._05mvcboot02.pojo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("re.kaguya._05mvcboot02.pojo.mapper")
public class MybatisConfig {

}
