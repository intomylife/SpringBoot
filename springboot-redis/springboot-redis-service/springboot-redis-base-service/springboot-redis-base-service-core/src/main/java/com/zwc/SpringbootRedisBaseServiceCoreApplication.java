package com.zwc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringbootRedisBaseServiceCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisBaseServiceCoreApplication.class, args);
    }

}
