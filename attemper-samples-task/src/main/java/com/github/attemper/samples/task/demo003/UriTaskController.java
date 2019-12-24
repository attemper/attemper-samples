package com.github.attemper.samples.task.demo003;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 区别于bean模式，调度中心的执行器将直接调用接口，而不通过sdk
 * 因此此方式适用于其他语言的web应用，比如PHP等
 */
@Slf4j
@RestController
public class UriTaskController {

    @PostMapping("/api/mytask")
    public void post() throws InterruptedException {
        log.debug("post start");
        Thread.sleep(4000);
        log.debug("post end");
    }

    @GetMapping("/api/mytask")
    public void get() throws InterruptedException {
        log.debug("get start");
        Thread.sleep(3000);
        log.debug("get end");
    }

    @PutMapping("/api/mytask")
    public void put() throws InterruptedException {
        log.debug("put start");
        Thread.sleep(2000);
        log.debug("put end");
    }

    @DeleteMapping("/api/mytask")
    public void delete() throws InterruptedException {
        log.debug("delete start");
        Thread.sleep(1000);
        log.debug("delete end");
    }
}
