package cn.aezio.microservice.study.web;

import cn.aezio.microservice.study.entity.Concert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ConcertController {

    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @GetMapping("/concert/{id}")
    public Concert getConcerts(@PathVariable long id) {
        Concert concert = this.restTemplate.
                getForObject("http://simple-provider/concert/1", Concert.class);
        return concert;
    }
}
