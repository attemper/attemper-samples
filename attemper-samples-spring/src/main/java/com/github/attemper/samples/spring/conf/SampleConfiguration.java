package com.github.attemper.samples.spring.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.attemper.java.sdk.rest.conf.RestConfiguration;
import com.github.attemper.samples.task.TaskConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        TaskConfiguration.class,
        RestConfiguration.class
})
public class SampleConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
