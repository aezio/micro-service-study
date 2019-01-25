package cn.aezio.microservice.study.web;

import cn.aezio.microservice.study.entity.Concert;
import cn.aezio.microservice.study.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/concert")
public class ConcertController {

    @Autowired
    private ConcertRepository concertRepository;

    @GetMapping("/{id}")
    public Concert getUser(@PathVariable("id") Long id) {
        return concertRepository.findById(id).get();
    }
}
