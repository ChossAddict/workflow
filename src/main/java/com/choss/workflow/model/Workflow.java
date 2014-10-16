package com.choss.workflow.model;

import java.util.ArrayList;
import java.util.List;

public class Workflow {

    private List<Step> steps = new ArrayList<Step>();

    public Workflow() {
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void addStep(Step step) {
        steps.add(step);
    }
}
