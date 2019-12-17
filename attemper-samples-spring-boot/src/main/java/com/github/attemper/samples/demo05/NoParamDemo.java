package com.github.attemper.samples.demo05;

import com.github.attemper.java.sdk.common.result.execution.LogResult;
import com.github.attemper.java.sdk.common.result.execution.TaskResult;
import com.github.attemper.samples.CommonService;
import org.springframework.stereotype.Service;

/**
 * bean=noParamDemo
 */
@Service
public class NoParamDemo extends CommonService {

    /**
     * method=step1
     * @return
     * @throws Exception
     */
    public LogResult step1() throws Exception {
        log.debug("step1 start");
        Thread.sleep(2000);
        log.debug("step1 end");
        return new TaskResult();
    }

    /**
     * method=step2
     * @return
     * @throws Exception
     */
    public void step2() throws Exception {
        log.debug("step2 start");
        Thread.sleep(3000);
        log.debug("step2 end");
    }

    /**
     * method=step3
     * @return
     * @throws Exception
     */
    public void step3() throws Exception {
        log.debug("step3 start");
        Thread.sleep(3000);
        log.debug("step3 end");
        System.out.println(1/0);
    }
}
