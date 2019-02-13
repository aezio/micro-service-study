package cn.aezio.microservice.study.web;

import cn.aezio.microservice.study.entity.User;
import cn.aezio.microservice.study.repository.UserRepository;
import cn.aezio.microservice.study.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
//        return userRepository.findById(id);
        return userFeignClient.getById(id);
    }
}
