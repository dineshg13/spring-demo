package com.dd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class DemoController {

    RestTemplate template = new RestTemplate();

    @GetMapping("/api/foo")
    @ResponseBody
    public String getFoo(@RequestParam(defaultValue = "test") String id) {
        log.info("in getFoo");
        String obj = template.getForObject("http://localhost:8081/" + id, String.class);
        log.info("obj=" + obj);
        return "ID: " + id;
    }

}
