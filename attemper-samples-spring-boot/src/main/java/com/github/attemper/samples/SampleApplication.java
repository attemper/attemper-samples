package com.github.attemper.samples;

import com.github.attemper.java.sdk.micro.executor.conf.ExecutorAutoConfiguration;
import com.github.attemper.java.sdk.micro.web.conf.WebAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@Import({
        ExecutorAutoConfiguration.class,
        WebAutoConfiguration.class
})
@EnableDiscoveryClient
@SpringBootApplication
public class SampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

}
