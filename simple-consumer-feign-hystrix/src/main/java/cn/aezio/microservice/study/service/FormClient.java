package cn.aezio.microservice.study.service;

import cn.aezio.microservice.study.config.FeignFormSupport;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * feign 表单上传
 */
@FeignClient(name = "simple-provider", configuration = FeignFormSupport.class)
public interface FormClient {

    @PostMapping(value = "/test",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}
    )
    void post(Map<String, ?> queryParam);
}
