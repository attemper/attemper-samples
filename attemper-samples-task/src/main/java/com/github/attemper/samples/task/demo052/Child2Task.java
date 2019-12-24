package com.github.attemper.samples.task.demo052;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Child2Task {

    public void child2Node1() throws InterruptedException {
        log.debug("child 2 node 1 start");
        Thread.sleep(2000);
        log.debug("child 2 node 1 end");
    }

    public void child2Node2() throws InterruptedException {
        log.debug("child 2 node 2 start");
        Thread.sleep(3500);
        log.debug("child 2 node 2 end");
    }
}
