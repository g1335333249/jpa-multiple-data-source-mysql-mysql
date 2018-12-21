package com.example.mysql;

import com.example.mysql.entity.primary.Application;
import com.example.mysql.entity.secondary.Application2;
import com.example.mysql.repository.primary.ApplicationRepository;
import com.example.mysql.repository.secondary.ApplicationRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author g1335333249
 */
@SpringBootApplication
public class MysqlMysqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(MysqlMysqlApplication.class, args);
    }

    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private ApplicationRepository2 applicationRepository2;

    @PostConstruct
    public void init() {
        List<Application> all = applicationRepository.findAll();
        System.out.println(all);
        List<Application2> all1 = applicationRepository2.findAll();
        System.out.println(all1);
    }
}

