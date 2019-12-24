package com.github.attemper.samples.task.demo150;

import com.github.attemper.java.sdk.common.result.BaseResult;
import com.github.attemper.java.sdk.common.web.result.delay.DelayJobResult;
import com.github.attemper.java.sdk.rest.web.service.DelayJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddDelayController {

    @Autowired
    private DelayJobService delayJobService;

    @GetMapping("/delay")
    public void add() {
        BaseResult<DelayJobResult> baseResult = delayJobService.startThenEnd("delayDemo", System.currentTimeMillis() + 10 * 1000);
        System.out.println(baseResult);
    }

}
