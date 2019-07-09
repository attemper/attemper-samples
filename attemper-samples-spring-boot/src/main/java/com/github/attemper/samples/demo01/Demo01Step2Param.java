package com.github.attemper.samples.demo01;

public class Demo01Step2Param {

    private String currentStep;

    private Boolean completed;

    public String getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Demo01Step2Param{" +
                "currentStep='" + currentStep + '\'' +
                ", completed=" + completed +
                '}';
    }
}
