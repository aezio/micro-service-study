package cn.aezio.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class SimpleConsumerHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleConsumerHystrixApplication.class, args);
    }

}

