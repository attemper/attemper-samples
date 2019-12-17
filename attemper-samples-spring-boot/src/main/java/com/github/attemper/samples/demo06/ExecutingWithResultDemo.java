package com.github.attemper.samples.demo06;

import com.github.attemper.java.sdk.common.result.execution.LogResult;
import com.github.attemper.java.sdk.rest.executor.template.ExecutingWithResult;
import org.springframework.stereotype.Service;

/**
 * bean=executingWithResultDemo
 */
@Service
public class ExecutingWithResultDemo implements ExecutingWithResult {

    /**
     * method=execute
     */
    @Override
    public LogResult execute() {
        System.out.println("executing with param and result");
        return new LogResult();
    }
}
