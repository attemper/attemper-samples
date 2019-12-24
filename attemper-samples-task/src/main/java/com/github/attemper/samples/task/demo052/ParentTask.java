package com.github.attemper.samples.task.demo052;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ParentTask {

    public void parentNode1() throws InterruptedException {
        log.debug("parent node 1 start");
        Thread.sleep(1000);
        log.debug("parent node 1 end");
    }


    public void parentNode2() throws InterruptedException {
        log.debug("parent node 2 start");
        Thread.sleep(1500);
        log.debug("parent node 2 end");
    }

}
