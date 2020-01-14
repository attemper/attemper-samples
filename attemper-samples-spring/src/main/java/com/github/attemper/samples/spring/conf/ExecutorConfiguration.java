package com.github.attemper.samples.spring.conf;

import com.github.attemper.java.sdk.rest.executor.client.ExecutorRestClient;
import com.github.attemper.java.sdk.rest.executor.conf.RestExecutorConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        RestExecutorConfiguration.class
})
public class ExecutorConfiguration {

    @Bean
    public ExecutorRestClient executorRestClient() {
        return new ExecutorRestClient();
    }

}
