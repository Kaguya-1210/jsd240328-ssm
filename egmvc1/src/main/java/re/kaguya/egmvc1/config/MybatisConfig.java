package re.kaguya.egmvc1.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("re.kaguya.egmvc1.mapper")
public class MybatisConfig {
}
