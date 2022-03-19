package com.ventura.multidatasource.core.configuration;

import com.ventura.multidatasource.core.common.AdsPackages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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

@Configuration
@PropertySource({"classpath:application.properties"})
/**
 * Any new entity that should be stored on ADS database, should be added on basePackages bellow
 * */
@EnableJpaRepositories(basePackages = AdsPackages.PREFERENCES,
        entityManagerFactoryRef = "adsEntityManager",
        transactionManagerRef = "adsTransactionManager")
public class AdsDatasourceConfiguration {

    @Autowired
    private Environment env;

    /**
     * Any new entity that should be stored on ADS database, should be added on ENTITY_PACKAGES bellow
     */
    private final String[] ENTITY_PACKAGES = {AdsPackages.PREFERENCES};


    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean adsEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(adsDataSource());
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

    @Primary
    @Bean
    public DataSource adsDataSource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("datasource.ads.driverClassName"));
        dataSource.setUrl(env.getProperty("datasource.ads.url"));
        dataSource.setUsername(env.getProperty("datasource.ads.username"));
        dataSource.setPassword(env.getProperty("datasource.ads.password"));

        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager adsTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                adsEntityManager().getObject());
        return transactionManager;
    }
}
