package com.github.attemper.samples.demo01;

public class Demo01Step1Param {

    private String today;

    private String nextBizDay;

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public String getNextBizDay() {
        return nextBizDay;
    }

    public void setNextBizDay(String nextBizDay) {
        this.nextBizDay = nextBizDay;
    }

    @Override
    public String toString() {
        return "Demo01Step1Param{" +
                "today='" + today + '\'' +
                ", nextBizDay='" + nextBizDay + '\'' +
                '}';
    }
}
