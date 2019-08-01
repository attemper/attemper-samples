package com.github.attemper.samples.spring.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.attemper.java.sdk.common.param.sys.login.LoginParam;
import com.github.attemper.java.sdk.rest.conf.RestConfiguration;
import com.github.attemper.java.sdk.rest.executor.conf.RestExecutorConfiguration;
import com.github.attemper.java.sdk.rest.web.client.WebRestClient;
import com.github.attemper.java.sdk.rest.web.service.DelayJobService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

@Configuration
@Import({
        RestConfiguration.class,
        RestExecutorConfiguration.class
})
public class SampleConfiguration {

    @Value("${dispatch.user-name}")
    private String userName;

    @Value("${dispatch.password}")
    private String password;

    @Value("${dispatch.web.service-urls}")
    private String serviceUrls;

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public WebRestClient webRestClient() {
        WebRestClient client = new WebRestClient();
        client.loginParam(new LoginParam()
                .setUserName(userName)
                .setPassword(password));
        client.serviceUrls(Arrays.asList(serviceUrls.split(",")));
        client.initialize();
        return client;
    }

    @Bean
    public DelayJobService delayJobService(WebRestClient webRestClient) {
        DelayJobService delayJobService = new DelayJobService();
        delayJobService.setWebRestClient(webRestClient);
        return delayJobService;
    }
}
