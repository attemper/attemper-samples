package com.github.attemper.samples.task;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.github.attemper.samples"
})
public class TaskConfiguration {
}
