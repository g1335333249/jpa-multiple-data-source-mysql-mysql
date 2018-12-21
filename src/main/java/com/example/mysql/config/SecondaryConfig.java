package com.example.mysql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * @author g1335333249
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(transactionManagerRef = "transactionManagerSecondary", entityManagerFactoryRef = "entityManagerFactorySecondary", basePackages = {"com.example.mysql.repository.secondary"})
public class SecondaryConfig {

    @Autowired
    @Qualifier("secondaryDataSource")
    private DataSource secondDataSource;
    @Resource
    private JpaProperties jpaProperties;

    @Bean("entityManagerSecondary")
    public EntityManager entityManagerSecondary(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySecondary(builder).getObject().createEntityManager();
    }

    @Bean("entityManagerFactorySecondary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary(EntityManagerFactoryBuilder builder) {

        return builder.dataSource(secondDataSource).properties(jpaProperties.getHibernateProperties(new HibernateSettings())).persistenceUnit("secondaryPersistenceUnit").packages("com.example.mysql.entity.secondary").build();
    }

    @Bean("transactionManagerSecondary")
    public JpaTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
    }
}
