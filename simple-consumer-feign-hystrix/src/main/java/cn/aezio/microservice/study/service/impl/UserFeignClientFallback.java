package cn.aezio.microservice.study.service.impl;

import cn.aezio.microservice.study.entity.User;
import cn.aezio.microservice.study.service.UserFeignClient;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public User getById(Long id) {
        return new User(1, "fall back mock user", 1);
    }
}
