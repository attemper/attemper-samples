package com.github.attemper.samples.spring.conf;

import com.github.attemper.java.sdk.common.param.sys.login.LoginParam;
import com.github.attemper.java.sdk.rest.web.client.WebRestClient;
import com.github.attemper.java.sdk.rest.web.service.DelayJobService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class WebConfiguration {

    @Value("${dispatch.user-name}")
    private String userName;

    @Value("${dispatch.password}")
    private String password;

    @Value("${dispatch.web.service-urls}")
    private String serviceUrls;

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
