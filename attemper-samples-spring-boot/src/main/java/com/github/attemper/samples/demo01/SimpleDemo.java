package com.github.attemper.samples.demo01;

import com.github.attemper.java.sdk.common.executor.param.execution.EndParam;
import com.github.attemper.java.sdk.common.executor.param.execution.TaskParam;
import com.github.attemper.java.sdk.common.result.execution.LogResult;
import com.github.attemper.java.sdk.common.result.execution.TaskResult;
import com.github.attemper.java.sdk.micro.executor.client.ExecutorMicroClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("simpleDemo")
public class SimpleDemo {

    @Autowired
    private ExecutorMicroClient executorMicroClient;

    /**
     * sync
     *
     * @param taskParam
     */
    public LogResult step1(TaskParam<Demo01Step1Param> taskParam) {
        System.out.println("step1's bizParam:\n" + taskParam.getBizParam());
        int sleeping = (int) Math.random() * 5000;
        try {
            Thread.sleep(sleeping);
        } catch (InterruptedException e) {
            return new TaskResult()
                    .setSuccess(false)
                    .setLogKey(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                    .setLogText(e.getMessage());
        }
        Map<String, Object> transmittedMap = new HashMap<>();
        transmittedMap.put("currentStep", "step1");
        transmittedMap.put("completed", true);
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("step1_sleeping", String.valueOf(sleeping));
        return new TaskResult().setParamMap(transmittedMap).setDataMap(dataMap);
    }

    /**
     * async
     *
     * @param taskParam
     */
    public LogResult step2(TaskParam<Demo01Step2Param> taskParam) {
        new Thread(() -> {
            System.out.println("step2 new thread");
            System.out.println("step2's bizParam:\n" + taskParam.getBizParam());
            int sleeping = (int) Math.random() * 50000;
            try {
                Thread.sleep(sleeping);
            } catch (InterruptedException e) {
                executorMicroClient.signal(
                        new EndParam()
                                .setBaseExecutionParam(taskParam.getMetaParam())
                                .setTaskResult((TaskResult) new TaskResult()
                                        .setSuccess(false)
                                        .setLogKey(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                                        .setLogText(e.getMessage())));
            }
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("step2_sleeping", String.valueOf(sleeping));
            executorMicroClient.signal(
                    new EndParam()
                            .setBaseExecutionParam(taskParam.getMetaParam())
                            .setTaskResult(new TaskResult().setDataMap(dataMap)));
        }).start();
        System.out.println("step2 main thread");
        return new LogResult();
    }
}
