package com.github.attemper.samples.task.demo050;

import com.github.attemper.java.sdk.common.executor.param.execution.TaskParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 有并发节点的任务
 */
@Slf4j
@Service
public class ParallelTask {

    public void node1() throws InterruptedException {
        log.debug("node1 start");
        Thread.sleep(2000);
        log.debug("node1 end");

    }

    public void node21() throws InterruptedException {
        log.debug("node21 start");
        Thread.sleep(3000);
        log.debug("node21 end");
    }

    public void node22(TaskParam<Void> taskParam) throws InterruptedException {
        log.debug("node22 start");
        Thread.sleep(2000);
        log.debug("node22 end");
    }

    public void node23() throws InterruptedException {
        log.debug("node23 start");
        Thread.sleep(1000);
        log.debug("node23 end");
    }

    public void node3() throws InterruptedException {
        log.debug("node3 start");
        Thread.sleep(3000);
        log.debug("node3 end");
    }
}
