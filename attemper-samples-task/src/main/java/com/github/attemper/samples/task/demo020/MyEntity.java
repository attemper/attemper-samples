package com.github.attemper.samples.task.demo020;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class MyEntity {

    private String country;

    private Boolean readable;

    private Integer age;

    private Double pi;

    private Long money;

    private Integer startDate;

    private Integer startTime;

    private Long startDateTime;

    private List<String> stockCodes;

    private Map<String, String> stockInfoMap;

    private Integer nextTradeDate;
}
