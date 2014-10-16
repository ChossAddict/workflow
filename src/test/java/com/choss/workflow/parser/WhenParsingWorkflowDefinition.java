package com.choss.workflow.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhenParsingWorkflowDefinition {

    private String definition = "Complete Leave Request(Leave Request ? Approve Leave : LeaveRequest)";

    @Test
    public void canParseOperationFromWorkflowDefinition() {
        String operation = getOperation();
        System.out.println(operation);
    }

    @Test
    public void canParseInputFromWorkflowDefinition() {
        String input = getInput();
        System.out.println(input);
    }

    @Test
    public void canParseOneDownstreamStemFromWorkflowDefinition() {
        String downstreamStep = getDownstreamStep();
        System.out.println(downstreamStep);
    }

    @Test
    public void canParseOutputFromWorkflowDefinition() {
        String downstreamStep = getOutput();
        System.out.println(downstreamStep);
    }

    @Test
    public void canCreateWorkflowDefinitionFromParsedDefinition() {
        WorkflowDefinition workflowDefinition = new WorkflowDefinition();
        StepDefinition stepDefinition = new StepDefinition(getOperation(),getInput(),getOutput(),getDownstreamStep());

        workflowDefinition.setStepDefinition(stepDefinition);

        assertEquals(workflowDefinition.getStepDefinition().getOperation(), "Complete Leave Request");
        assertEquals(workflowDefinition.getStepDefinition().getInput(), "Leave Request");
        assertEquals(workflowDefinition.getStepDefinition().getOutput(), "Approve Leave");
        assertEquals(workflowDefinition.getStepDefinition().getNextSteps(), "LeaveRequest");
    }

    private String getOperation() {
        return definition.substring(0, definition.indexOf("("));
    }

    private String getInput() {
        return definition.substring((definition.indexOf("(") + 1), (definition.indexOf("?") - 1));
    }

    private String getDownstreamStep() {
        return definition.substring((definition.indexOf("?") + 2), (definition.indexOf(":") - 1));
    }

    private String getOutput() {
        return definition.substring((definition.indexOf(":") + 2), definition.indexOf(")"));
    }
}
