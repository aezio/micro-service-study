package cn.aezio.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SimpleConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleConsumerFeignApplication.class, args);
    }

}

