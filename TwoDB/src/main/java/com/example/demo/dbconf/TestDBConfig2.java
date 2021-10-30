package com.example.demo.dbconf;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "testEntityManagerFactory",
  transactionManagerRef = "testTransactionManager",
  basePackages = { "com.example.demo.repo1" }
)
public class TestDBConfig2 {
  

  @Bean(name = "testDataSource")
  @ConfigurationProperties(prefix = "student.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
  
  @Bean(name = "testEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean 
  entityManagerFactory(
    EntityManagerFactoryBuilder builder,
    @Qualifier("testDataSource") DataSource dataSource
  ) {
    return builder
      .dataSource(dataSource)
      .packages("com.example.demo.model1")
      .persistenceUnit("test")
      .build();
  }
    
  @Bean(name = "testTransactionManager")
  public PlatformTransactionManager transactionManager(
    @Qualifier("testEntityManagerFactory") EntityManagerFactory 
    entityManagerFactory
  ) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}