package cn.aezio.microservice.study;

import cn.aezio.microservice.study.entity.Concert;
import cn.aezio.microservice.study.repository.ConcertRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SimpleProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleProviderApplication.class, args);
    }


    @Bean
    ApplicationRunner init(ConcertRepository repository) {
        return args -> {
            Concert concert1 = new Concert(1L, "张三演唱会", "某体育场", 100);
            Concert concert2 = new Concert(2L, "李四演唱会", "某体育场", 100);
            Concert concert3 = new Concert(3L, "王五演唱会", "某体育场", 100);
            Stream.of(concert1, concert2, concert3)
                    .forEach(repository::save);
        };
    }
}

