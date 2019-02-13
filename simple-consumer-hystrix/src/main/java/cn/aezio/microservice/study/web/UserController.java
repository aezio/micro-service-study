package cn.aezio.microservice.study.web;

import cn.aezio.microservice.study.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    @HystrixCommand(fallbackMethod = "fallback")
    public User getUser(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://simple-provider/user/{id}", User.class, id);
    }

    public User fallback(Long id, Throwable throwable) {
        log.error("进入回退方法", throwable);
        return new User(id, "fallbackUser", 1);
    }
}
