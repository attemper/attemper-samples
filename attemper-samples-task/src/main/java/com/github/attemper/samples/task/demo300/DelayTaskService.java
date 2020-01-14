package com.github.attemper.samples.task.demo300;

import com.github.attemper.java.sdk.common.executor.param.execution.TaskParam;
import com.github.attemper.java.sdk.rest.executor.template.ExecutingWithParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DelayTaskService implements ExecutingWithParam<DelayParam> {

    public void execute(TaskParam<DelayParam> taskParam) throws Exception {
        log.debug("delay step1 start");
        log.debug("delayId:{}", taskParam.getBizParam().getDelayId());
        Thread.sleep(2000);
        log.debug("delay step1 end");
    }
}
