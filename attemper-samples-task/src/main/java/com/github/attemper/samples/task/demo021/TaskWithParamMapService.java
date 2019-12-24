package com.github.attemper.samples.task.demo021;

import com.github.attemper.java.sdk.common.executor.param.execution.TaskParam;
import com.github.attemper.java.sdk.rest.executor.template.ExecutingWithParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 通过Map接收业务参数
 */
@Slf4j
@Service
public class TaskWithParamMapService implements ExecutingWithParam<Map<String, Object>> {

    @Override
    public void execute(TaskParam<Map<String, Object>> taskParam) {
        log.debug("execute start");
        Map<String, Object> bizParam = taskParam.getBizParam();
        if (bizParam != null) {
            log.debug(bizParam.toString());
        }
        log.debug("execute end");
    }

}
