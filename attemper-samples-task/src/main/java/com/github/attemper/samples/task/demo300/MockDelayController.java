package com.github.attemper.samples.task.demo300;

import com.github.attemper.java.sdk.common.result.BaseResult;
import com.github.attemper.java.sdk.common.util.StringUtils;
import com.github.attemper.java.sdk.common.web.result.delay.DelayJobResult;
import com.github.attemper.java.sdk.rest.web.service.DelayJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟业务系统的前端请求，向调度中心新增延迟任务
 */
@Slf4j
@RestController
public class MockDelayController {

    @Autowired
    private DelayJobService delayJobService;

    /**
     * 可直接在浏览器输入http://127.0.0.1:8080/delay/add，为该任务新增一个10秒后执行的延迟任务
     */
    @GetMapping("/delay/add")
    public String add(Integer delayedInSeconds) {
        if (delayedInSeconds == null || delayedInSeconds < 1) {
            delayedInSeconds = 10;
        }
        log.debug("add delay job start");
        BaseResult<DelayJobResult> baseResult = delayJobService.startThenEnd("demo300_delay_job", System.currentTimeMillis() + delayedInSeconds * 1000);
        log.debug("add delay job end.result={}", baseResult);
        return baseResult.toString();
    }

    /**
     * 可直接在浏览器输入http://127.0.0.1:8080/delay/delete?id={delayId}，删除该延迟任务的实例
     */
    @GetMapping("/delay/delete")
    public String delete(String id) {
        if (StringUtils.isBlank(id)) {
            return "delay id can't be blank";
        }
        log.debug("delete delay job start");
        BaseResult<Void> baseResult = delayJobService.delete(id);
        log.debug("delete delay job end.result={}", baseResult);
        return baseResult.toString();
    }

}
