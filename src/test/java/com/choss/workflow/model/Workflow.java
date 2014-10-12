package com.choss.workflow.model;

import java.util.ArrayList;
import java.util.List;

public class Workflow {

    private List<Operation> operations = new ArrayList<Operation>();

    public Workflow() {
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }
}
