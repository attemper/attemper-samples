package com.github.attemper.samples.demo05;

import com.github.attemper.java.sdk.common.result.execution.LogResult;
import com.github.attemper.java.sdk.common.result.execution.TaskResult;
import com.github.attemper.samples.CommonService;
import org.springframework.stereotype.Service;

@Service
public class NoParamDemo extends CommonService {

    public LogResult step1() throws Exception {
        log.debug("step1 start");
        Thread.sleep(2000);
        log.debug("step1 end");
        return new TaskResult();
    }

    public void step2() throws Exception {
        log.debug("step2 start");
        Thread.sleep(3000);
        log.debug("step2 end");
    }

    public void step3() throws Exception {
        log.debug("step3 start");
        Thread.sleep(3000);
        log.debug("step3 end");
        System.out.println(1/0);
    }
}
