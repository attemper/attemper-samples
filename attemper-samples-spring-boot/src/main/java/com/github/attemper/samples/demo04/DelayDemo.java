package com.github.attemper.samples.demo04;

import com.github.attemper.java.sdk.common.executor.param.execution.TaskParam;
import com.github.attemper.java.sdk.common.result.execution.LogResult;
import com.github.attemper.java.sdk.common.result.execution.TaskResult;
import com.github.attemper.samples.CommonService;
import org.springframework.stereotype.Service;

/**
 * bean=delayDemo
 */
@Service
public class DelayDemo extends CommonService {

    /**
     * method=step1
     *
     * @param taskParam
     */
    public LogResult step1(TaskParam<DelayParam> taskParam) throws Exception {
        log.debug("delay step1 start");
        log.debug("delayId:{}", taskParam.getBizParam().getDelayId());
        Thread.sleep(2000);
        log.debug("delay step1 end");
        return new TaskResult();
    }
}
