package lk.ijse.dep.web.pos;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
@PropertySource("classpath:/application.properties")
public class JPAConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSource);
        lcemfb.setJpaVendorAdapter(jpaVendorAdapter);
        lcemfb.setPackagesToScan("lk.ijse.dep.web.pos.entity");
        return lcemfb;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName(env.getRequiredProperty("dbcp.jdbc.driver"));
        bds.setUrl(env.getRequiredProperty("dbcp.jdbc.url"));
        bds.setUsername(env.getRequiredProperty("dbcp.jdbc.user"));
        bds.setPassword(env.getRequiredProperty("dbcp.jdbc.password"));
        bds.setInitialSize(env.getRequiredProperty("dbcp.initial_size", Integer.class));
        bds.setMaxTotal(env.getRequiredProperty("dbcp.max_total", Integer.class));
        return bds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(env.getRequiredProperty("jpa.show_sql", Boolean.class));
        adapter.setGenerateDdl(env.getRequiredProperty("jpa.generated_ddl", Boolean.class));
        adapter.setDatabasePlatform(env.getRequiredProperty("jpa.dialect"));
        return adapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

//    private Properties jpaProperties(){
//        Properties prop = new Properties();
//        prop.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
//        prop.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
//        prop.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
//        return prop;
//    }
}
