package cn.aezio.microservice.study.service;

import cn.aezio.microservice.study.entity.User;
import cn.aezio.microservice.study.service.impl.UserFeignClientFallback;
import feign.Feign;
import feign.hystrix.HystrixFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simple-provider", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping("/concert/{id}")
    User getById(@PathVariable Long id);

    /**
     * feign局部启用 hystrix ，在configuration参数中指定此类
     */
    class FeignEnableHystrixConfiguration {
        @Bean
        @Scope("prototype")
        public HystrixFeign.Builder feignBuilder() {
            return HystrixFeign.builder();
        }
    }

    /**
     * feign局部禁用 hystrix ，在configuration参数中指定此类
     */
    class FeignDisableHystrixConfiguration {
        @Bean
        @Scope("prototype")
        public Feign.Builder feignBuilder() {
            return Feign.builder();
        }
    }
}
