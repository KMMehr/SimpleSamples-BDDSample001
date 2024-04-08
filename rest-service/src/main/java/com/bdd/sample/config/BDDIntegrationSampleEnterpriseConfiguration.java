package com.bdd.sample.config;


import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceInitializationMode;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
@ConditionalOnProperty(prefix = "BDDSample", name = "Edition", havingValue = "Enterprise")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.bdd.sample.domain.repository"},
        entityManagerFactoryRef = "bddSampleEntityManagerFactory",
        transactionManagerRef = "bddSampleTransactionManager")
public class BDDIntegrationSampleEnterpriseConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.bdd-sample-ent-ds")
    public DataSourceProperties bddSampleDataSourceProperties() {
        DataSourceProperties  dataSourceProperties =new DataSourceProperties();
        return dataSourceProperties ;
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.bdd-sample-ent-ds.hikari")
    public DataSource bddSampleHikariDataSource() {
        HikariDataSource hikariDataSource = bddSampleDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
        return hikariDataSource;
    }

    @Primary
    @PersistenceContext(unitName = "bddSampleEntityManagerPersistenceContextUnit")
    @Bean(name = "bddSampleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean bddSampleEntityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
        System.out.println("call bddSampleEntityManagerFactory >> Enterprise Edition");
        Map<String, Object> propertiesMap = new HashMap<>();
        propertiesMap.put("hibernate.database", "oracle");
        propertiesMap.put("hibernate.implicit_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");
        propertiesMap.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
        propertiesMap.put("hibernate.hbm2ddl.auto",  "update");
        propertiesMap.put("hibernate.default_schema", "BDD_SAMPLE");
        propertiesMap.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
        propertiesMap.put("hibernate.transaction.jta.platform", "NoJtaPlatform");
        propertiesMap.put("hibernate.temp.use_jdbc_metadata_defaults", "true");

        return entityManagerFactoryBuilder
                .dataSource(bddSampleHikariDataSource())
                .packages("com.bdd.sample.domain.model")
                .properties(propertiesMap)
                .persistenceUnit("bddSampleEntityManagerPersistenceContextUnit")
                .build();
    }

    @Primary
    @Bean(name = "bddSampleTransactionManager")
    public PlatformTransactionManager bddSampleTransactionManager(
            final @Qualifier("bddSampleEntityManagerFactory") LocalContainerEntityManagerFactoryBean bddSampleEntityManagerFactory) {
        return new JpaTransactionManager(bddSampleEntityManagerFactory.getObject());
    }
}

