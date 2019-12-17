package com.github.attemper.samples.demo06;

import com.github.attemper.java.sdk.common.executor.param.execution.TaskParam;
import com.github.attemper.java.sdk.common.result.execution.LogResult;
import com.github.attemper.java.sdk.rest.executor.template.ExecutingWithParamAndResult;
import org.springframework.stereotype.Service;

/**
 * bean=executingWithParamAndResultDemo
 */
@Service
public class ExecutingWithParamAndResultDemo implements ExecutingWithParamAndResult<Void> {

    /**
     * method=execute
     */
    @Override
    public LogResult execute(TaskParam<Void> param) {
        System.out.println("executing with param and result");
        return new LogResult();
    }
}
