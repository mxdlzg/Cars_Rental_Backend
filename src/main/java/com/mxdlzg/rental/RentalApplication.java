package com.mxdlzg.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class RentalApplication {

//    @Bean
//    public Object testBean(PlatformTransactionManager platformTransactionManager){
//        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
//        return new Object();
//    }

    public static void main(String[] args) {
        SpringApplication.run(RentalApplication.class, args);
    }

}
