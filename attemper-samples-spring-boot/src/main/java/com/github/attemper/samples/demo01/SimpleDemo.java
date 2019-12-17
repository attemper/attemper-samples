package com.github.attemper.samples.demo01;

import com.github.attemper.java.sdk.common.executor.param.execution.EndParam;
import com.github.attemper.java.sdk.common.executor.param.execution.TaskParam;
import com.github.attemper.java.sdk.common.result.execution.LogResult;
import com.github.attemper.java.sdk.common.result.execution.TaskResult;
import com.github.attemper.java.sdk.micro.executor.client.ExecutorMicroClient;
import com.github.attemper.samples.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * bean=simpleDemo
 */
@Service
public class SimpleDemo extends CommonService {

    @Autowired
    private ExecutorMicroClient executorMicroClient;

    /**
     * method=step1
     *
     * @param taskParam
     */
    public LogResult step1(TaskParam<Demo01Step1Param> taskParam) throws Exception {
        log.debug("step1's bizParam:\n" + taskParam.getBizParam());
        int sleeping = (int) (Math.random() * 5);
        Thread.sleep(sleeping * 1000);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("currentStep", "step1");
        paramMap.put("completed", true);
        paramMap.put("step1_sleeping", sleeping);
        return new TaskResult().setParamMap(paramMap);
    }

    /**
     * method=step2
     *
     * @param taskParam
     */
    public void step2(TaskParam<Demo01Step2Param> taskParam) {
        new Thread(() -> {
            log.debug("step2 new thread");
            log.debug("step2's bizParam:\n" + taskParam.getBizParam());
            int sleeping = (int) (Math.random() * 5);
            try {
                Thread.sleep(sleeping * 1000);
            } catch (InterruptedException e) {
                executorMicroClient.signal(
                        new EndParam()
                                .setBaseExecutionParam(taskParam.getMetaParam())
                                .setTaskResult((TaskResult) new TaskResult()
                                        .setSuccess(false)
                                        .setLogText(e.getMessage())));
            }
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("step2_sleeping", sleeping);
            executorMicroClient.signal(
                    new EndParam()
                            .setBaseExecutionParam(taskParam.getMetaParam())
                            .setTaskResult(new TaskResult().setParamMap(paramMap)));
        }).start();
        log.debug("step2 main thread");
    }
}
