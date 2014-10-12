package com.choss.workflow.model;

public class Operation {

    private String name;
    private String inputType;

    public Operation(String name, String inputType) {
        this.name = name;
        this.inputType = inputType;
    }

    public String getName() {
        return name;
    }

    public String getInputType() {
        return inputType;
    }
}
