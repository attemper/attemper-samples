package com.github.attemper.samples.spring.demo04;

import com.github.attemper.java.sdk.common.result.BaseResult;
import com.github.attemper.java.sdk.common.web.result.delay.DelayJobResult;
import com.github.attemper.java.sdk.rest.web.service.DelayJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AddDelayController {

    @Autowired
    private DelayJobService delayJobService;

    @GetMapping("/delay")
    public void add() {
        Date now = new Date();
        Date startTime = new Date(now.getTime() + 10 * 1000);
        BaseResult<DelayJobResult> baseResult = delayJobService.startThenEnd("delayDemo", startTime);
        System.out.println(baseResult);
    }

}
