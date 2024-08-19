package io.ratel.managesystem.common.db;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = {"io.ratel.managesystem.domain.account",
                        "io.ratel.managesystem.web_api.account",
                        "io.ratel.managesystem.domain.application",},
        entityManagerFactoryRef = "accountEntityManagerFactory",
        transactionManagerRef = "accountTransactionManager"
)
public class AccountDbConfig {

    @Primary
    @Bean(name = "accountDataSource")
    @ConfigurationProperties(prefix = "spring.datasource-msqlacct")
    public DataSource accountDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "accountEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean accountEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("accountDataSource") DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages("io.ratel.managesystem.domain.account",
                          "io.ratel.managesystem.web_api.account",
                          "io.ratel.managesystem.domain.application")  // Account 엔티티 클래스 패키지
                .persistenceUnit("accountPersistenceUnit")
                .build();
    }

    @Primary
    @Bean(name = "accountTransactionManager")
    public PlatformTransactionManager accountTransactionManager(
            @Qualifier("accountEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

