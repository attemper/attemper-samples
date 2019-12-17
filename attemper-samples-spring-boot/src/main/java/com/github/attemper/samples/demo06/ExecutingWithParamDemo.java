package com.github.attemper.samples.demo06;

import com.github.attemper.java.sdk.common.executor.param.execution.TaskParam;
import com.github.attemper.java.sdk.rest.executor.template.ExecutingWithParam;
import org.springframework.stereotype.Service;

/**
 * bean=executingWithParamDemo
 */
@Service
public class ExecutingWithParamDemo implements ExecutingWithParam<Void> {

    /**
     * method=execute
     */
    @Override
    public void execute(TaskParam<Void> param) {
        System.out.println("executing with param");
    }
}
