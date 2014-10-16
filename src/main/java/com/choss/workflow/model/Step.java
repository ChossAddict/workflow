package com.choss.workflow.model;

public class Step {

    private String operation;
    private String inputType;
    private String output;
    private String downstreamStep;

    public Step(String operation, String input, String output, String downstreamStep) {
        this.operation = operation;
        this.inputType = input;
        this.output = output;
        this.downstreamStep = downstreamStep;
    }

    public String getOperation() {
        return operation;
    }

    public String getInput() {
        return inputType;
    }

    public String getOutput() {
        return output;
    }

    public String getDownstreamStep() {
        return downstreamStep;
    }
}
