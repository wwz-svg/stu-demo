package org.example.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/*
 *@ClassName RabbitMQProvider
 *@Description TODO
 *@Author 武万章
 *@Date 2021/11/17 17:04
 */
@Configuration
@SpringBootApplication(scanBasePackages = {"org.example.rabbitmq"})
public class RabbitMQProvider {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQProvider.class,args);
    }
}
