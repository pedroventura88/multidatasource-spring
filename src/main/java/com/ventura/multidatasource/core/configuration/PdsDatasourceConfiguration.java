package com.ventura.multidatasource.core.configuration;

import com.ventura.multidatasource.core.common.AdsPackages;
import com.ventura.multidatasource.core.common.PdsPackages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@PropertySource({"classpath:application.properties"})
/**
 * Any new entity that should be stored on PDS database, should be added on basePackages bellow
 * */
@EnableJpaRepositories(basePackages = {PdsPackages.REMEDIATION, PdsPackages.PLAN},
        entityManagerFactoryRef = "pdsEntityManager",
        transactionManagerRef = "pdsTransactionManager")
@Configuration
public class PdsDatasourceConfiguration {
    @Autowired
    private Environment env;

    /**
     * Any new entity that should be stored on PDS database, should be added on ENTITY_PACKAGES bellow
     */
    private final String[] ENTITY_PACKAGES = {PdsPackages.REMEDIATION, PdsPackages.PLAN};

    @Bean
    public LocalContainerEntityManagerFactoryBean pdsEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(pdsDataSource());
        em.setPackagesToScan(ENTITY_PACKAGES);

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public DataSource pdsDataSource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("datasource.pds.driverClassName"));
        dataSource.setUrl(env.getProperty("datasource.pds.url"));
        dataSource.setUsername(env.getProperty("datasource.pds.username"));
        dataSource.setPassword(env.getProperty("datasource.pds.password"));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager pdsTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                pdsEntityManager().getObject());
        return transactionManager;
    }
}
