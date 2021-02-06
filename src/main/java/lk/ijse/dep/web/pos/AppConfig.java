package lk.ijse.dep.web.pos;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
@Import(JPAConfig.class)
public class AppConfig {
}
