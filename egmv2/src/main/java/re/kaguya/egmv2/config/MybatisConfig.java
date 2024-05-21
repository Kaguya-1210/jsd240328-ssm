package re.kaguya.egmv2.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("re.kaguya.egmv2.mapper")
public class MybatisConfig {
}