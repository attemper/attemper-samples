package com.github.attemper.samples.task.demo052;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Child1Task {

    public void child1Node1() throws InterruptedException {
        log.debug("child 1 node 1 start");
        Thread.sleep(3000);
        log.debug("child 1 node 1 end");
    }

    public void child1Node2() throws InterruptedException {
        log.debug("child 2 node 2 start");
        Thread.sleep(2500);
        log.debug("child 2 node 2 end");
    }
}
