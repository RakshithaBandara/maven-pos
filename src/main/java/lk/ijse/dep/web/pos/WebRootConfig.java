package lk.ijse.dep.web.pos;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import(JPAConfig.class)
@EnableJpaRepositories(basePackages = "lk.ijse.dep.web.pos.dao")
public class WebRootConfig {
}
