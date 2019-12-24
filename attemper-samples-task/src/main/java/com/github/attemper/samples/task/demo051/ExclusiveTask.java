package com.github.attemper.samples.task.demo051;

import com.github.attemper.java.sdk.common.result.execution.LogResult;
import com.github.attemper.java.sdk.common.result.execution.TaskResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ExclusiveTask {

    /**
     * 返回随机数randomValue
     * randomValue>0.5 执行node2，randomValue<=0.5执行node3
     * @return
     * @throws InterruptedException
     */
    public LogResult node1() throws InterruptedException {
        log.debug("node1 start");
        Thread.sleep(2000);
        log.debug("node1 end");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("randomValue", Math.random());
        return new TaskResult().setParamMap(paramMap);
    }

    public void node2() throws InterruptedException {
        log.debug("node2 start");
        Thread.sleep(3000);
        log.debug("node2 end");
    }

    public void node3() throws InterruptedException {
        log.debug("node3 start");
        Thread.sleep(1000);
        log.debug("node3 end");
    }
}
