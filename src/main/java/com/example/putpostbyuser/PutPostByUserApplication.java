package com.example.putpostbyuser;

import com.example.putpostbyuser.repository.impl.BaseRepositoryImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)

public class PutPostByUserApplication implements CommandLineRunner {


    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    public static void main(String[] args) {

        SpringApplication.run(PutPostByUserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(encoder.encode("admin123"));
    }
}
