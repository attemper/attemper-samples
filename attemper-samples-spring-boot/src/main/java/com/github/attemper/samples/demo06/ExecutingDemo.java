package com.github.attemper.samples.demo06;

import com.github.attemper.java.sdk.rest.executor.template.Executing;
import org.springframework.stereotype.Service;

/**
 * bean=executingDemo
 */
@Service
public class ExecutingDemo implements Executing {

    /**
     * method=execute
     */
    @Override
    public void execute() {
        System.out.println("executing");
    }
}
