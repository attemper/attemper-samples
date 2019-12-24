package com.github.attemper.samples.task.demo020;

import com.github.attemper.java.sdk.common.executor.param.execution.TaskParam;
import com.github.attemper.java.sdk.rest.executor.template.ExecutingWithParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 通过实体对象接收业务参数
 */
@Slf4j
@Service
public class TaskWithParamEntityService implements ExecutingWithParam<MyEntity> {

    @Override
    public void execute(TaskParam<MyEntity> taskParam) {
        log.debug("execute start");
        MyEntity bizParam = taskParam.getBizParam();
        if (bizParam != null) {
            log.debug(bizParam.toString());
        }
        log.debug("execute end");
    }

}
