package com.dd.controller;

import com.dd.forkjoin.CustomRecursiveTask;
import com.dd.model.TaskRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.opentelemetry.context.Context;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ForkJoinPool;

@RestController
@Slf4j
public class DemoController {

  RestTemplate template = new RestTemplate();
  ForkJoinPool fjp = new ForkJoinPool();

  @GetMapping("/echo")
  @ResponseBody
  public String echo(@RequestParam(defaultValue = "test") String id) {
    log.info("in echo");
    return "ID: " + id;
  }

  @PostMapping("/recursive")
  @ResponseBody
  public Integer task(@RequestBody String json) {

    ObjectMapper mapper = new ObjectMapper();

    log.info("in task, json:"+json);


    try {
      TaskRequest request = mapper.readValue(json, TaskRequest.class);

      return fjp.invoke(new CustomRecursiveTask(Context.current(),request.getAr()));
    } catch (Exception e) {
      log.error(e.getMessage(),e);
      throw new RuntimeException(e);
    }
  }

  @GetMapping("/api/foo")
  @ResponseBody
  public String getFoo(@RequestParam(defaultValue = "test") String id) {
    log.info("in getFoo");
    String obj = template.getForObject("http://localhost:8081/" + id, String.class);
    log.info("obj=" + obj);
    return "ID: " + id;
  }
}
