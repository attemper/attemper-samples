package com.github.attemper.samples.task.demo002;

import com.github.attemper.java.sdk.common.executor.param.execution.EndParam;
import com.github.attemper.java.sdk.common.executor.param.execution.TaskParam;
import com.github.attemper.java.sdk.common.result.execution.TaskResult;
import com.github.attemper.java.sdk.rest.executor.client.ExecutorRestClient;
import com.github.attemper.java.sdk.rest.executor.template.ExecutingWithParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Http 异步任务
 * 在被调用时，调度中心的执行器在调用被调系统后，被调系统即返回结果，执行器对该任务加锁，直到被调系统通知执行器该任务结束或超时
 */
@Slf4j
@Service
public class HttpAsyncService implements ExecutingWithParam<Void> {

    @Autowired
    private ExecutorRestClient executorRestClient;

    @Override
    public void execute(TaskParam<Void> taskParam) {
        log.debug("main thread start");
        new Thread(() -> {
            log.debug("inner thread start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                executorRestClient.signal(
                        new EndParam()
                                .setBaseExecutionParam(taskParam.getMetaParam())
                                .setTaskResult((TaskResult) new TaskResult()
                                        .setSuccess(false)
                                        .setLogText(e.getMessage())));
            }
            executorRestClient.signal(
                    new EndParam()
                            .setBaseExecutionParam(taskParam.getMetaParam()));
            log.debug("inner thread end");
        }).start();
        log.debug("main thread end");
    }
}
