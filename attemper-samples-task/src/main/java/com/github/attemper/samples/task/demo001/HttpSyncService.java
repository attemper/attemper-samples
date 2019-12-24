package com.github.attemper.samples.task.demo001;

import com.github.attemper.java.sdk.rest.executor.template.Executing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Http 同步任务
 * 在被调用时，调度中心的执行器与被调系统间保持长连接，直到任务执行完成或超时
 */
@Slf4j
@Service
public class HttpSyncService implements Executing {

    @Override
    public void execute() throws InterruptedException {
        log.debug("execute start");
        Thread.sleep(3000);
        log.debug("execute end");
    }
}
