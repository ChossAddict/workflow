package com.choss.workflow.parser;

public class StepDefinition {
    private final String operation;
    private final String input;
    private final String output;
    private final String nextSteps;

    public StepDefinition(String operation, String input, String output, String nextSteps) {
        this.operation = operation;
        this.input = input;
        this.output = output;
        this.nextSteps = nextSteps;
    }

    public String getInput() {
        return input;
    }

    public String getOperation() {
        return operation;
    }

    public String getOutput() {
        return output;
    }

    public String getNextSteps() {
        return nextSteps;
    }
}
