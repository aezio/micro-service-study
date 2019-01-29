package cn.aezio.microservice.study.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;

public class FeignMultipartFileSupport {

    @Bean
    public Encoder feignEncoder() {
        return new SpringFormEncoder();
    }
}
