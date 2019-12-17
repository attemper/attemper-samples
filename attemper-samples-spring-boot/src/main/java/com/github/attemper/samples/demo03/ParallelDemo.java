package com.github.attemper.samples.demo03;

import com.github.attemper.java.sdk.common.executor.param.execution.EndParam;
import com.github.attemper.java.sdk.common.executor.param.execution.TaskParam;
import com.github.attemper.java.sdk.common.result.execution.LogResult;
import com.github.attemper.java.sdk.common.result.execution.TaskResult;
import com.github.attemper.java.sdk.micro.executor.client.ExecutorMicroClient;
import com.github.attemper.samples.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * bean=parallelDemo
 */
@Service
public class ParallelDemo extends CommonService {

    @Autowired
    private ExecutorMicroClient executorMicroClient;

    /**
     * method=step1
     *
     * @param taskParam
     */
    public LogResult step1(TaskParam<Void> taskParam) throws Exception {
        log.debug("step1 start");
        Thread.sleep(2000);
        log.debug("step1 end");
        return new TaskResult();

    }

    /**
     * method=step21
     *
     * @param taskParam
     */
    public LogResult step21(TaskParam<Void> taskParam) throws Exception {
        log.debug("step21 start");
        Thread.sleep(2000);
        log.debug("step21 end");
        return new TaskResult();
    }

    /**
     * method=step22
     *
     * @param taskParam
     */
    public void step22(TaskParam<Void> taskParam) throws Exception {
        new Thread(() -> {
            log.debug("step22 start");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
            executorMicroClient.signal(
                    new EndParam()
                            .setBaseExecutionParam(taskParam.getMetaParam())
                            .setTaskResult(new TaskResult()));
            log.debug("step22 end");
        }).start();
    }

    /**
     * method=step23
     *
     * @param taskParam
     */
    public LogResult step23(TaskParam<Void> taskParam) throws Exception {
        log.debug("step23 start");
        Thread.sleep(6000);
        log.debug("step23 end");
        return new TaskResult();
    }

    /**
     * method=step3
     *
     * @param taskParam
     */
    public LogResult step3(TaskParam<Void> taskParam) throws Exception {
        log.debug("step3 start");
        Thread.sleep(3000);
        log.debug("step3 end");
        return new TaskResult();
    }
}
