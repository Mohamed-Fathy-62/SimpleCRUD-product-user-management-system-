package com.example.BackendCrud.UserProduct.management.system.config;

import com.example.BackendCrud.UserProduct.management.system.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {
    @Bean
    public EntityManager em(){
        Map<String ,String> props = new HashMap<>();
        //change with liquibase
        props.put("hibernate.hbm2ddl.auto", "update"); //bad practice and inconsistent but used for example

        props.put("hibernate.show_sql", "true");

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), props);

        return emf.createEntityManager();
    }
}
