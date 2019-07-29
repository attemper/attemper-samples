package com.github.attemper.samples.demo4;

import com.github.attemper.java.sdk.rest.web.service.DelayJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
public class AddDelayController {

    @Autowired
    private DelayJobService delayJobService;

    @PostMapping("/delay/add")
    public void add(@RequestBody Map<String, Object> map) {
        Date now = new Date();
        delayJobService.add("delayDemo", new Date(now.getTime() + 10 * 1000));
    }

}
