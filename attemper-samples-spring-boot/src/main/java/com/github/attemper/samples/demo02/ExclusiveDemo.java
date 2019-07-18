package com.github.attemper.samples.demo02;

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

@Service
public class ExclusiveDemo extends CommonService {

    @Autowired
    private ExecutorMicroClient executorMicroClient;

    /**
     * async
     *
     * @param taskParam
     */
    public void step1(TaskParam<Void> taskParam) {
        new Thread(() -> {
            log.debug("step1 new thread");
            int sleeping = (int) (Math.random() * 5);
            try {
                Thread.sleep(sleeping * 1000);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("step1_sleeping", sleeping);
            executorMicroClient.signal(
                    new EndParam()
                            .setBaseExecutionParam(taskParam.getMetaParam())
                            .setTaskResult(new TaskResult().setParamMap(paramMap)));
        }).start();
        System.out.println("step1 main thread");

    }

    /**
     * sync
     *
     * @param taskParam
     */
    public LogResult step2(TaskParam<Map<String, Object>> taskParam) throws Exception {
        log.debug("-------------step2 running----------");
        log.debug("step2's bizParam:\n" + taskParam.getBizParam());
        int sleeping = (int) (Math.random() * 5);
        Thread.sleep(sleeping * 1000);
        return new TaskResult();
    }
}
