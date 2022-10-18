package com.dd.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> hello(@RequestParam Integer num) {
        if (num == 0) {
            throw new RuntimeException("num is zero");
        }
        Map<String, String> map = new HashMap<>();
        map.put("response", "Hello World!!" + num);
        return map;

    }

    @GetMapping("/api/foos")
    @ResponseBody
    public String getFoos(@RequestParam(defaultValue = "test") String id) {
        return "ID: " + id;
    }

}
