package cn.aezio.microservice.study.service;

import cn.aezio.microservice.study.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simple-provider")
public interface UserFeignClient {

    @GetMapping("/concert/{id}")
    User getById(@PathVariable Long id);
}
