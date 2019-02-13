package cn.aezio.microservice.study.service.impl;

import cn.aezio.microservice.study.entity.User;
import cn.aezio.microservice.study.service.UserFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    /**
     * 带错误原因的fallback
     *
     * @param throwable Throwable
     * @return UserFeignClient
     */
    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User getById(Long id) {
                log.error("进入回退逻辑", throwable);
                return new User(1, "fall back mock user", 1);
            }
        };
    }
}
