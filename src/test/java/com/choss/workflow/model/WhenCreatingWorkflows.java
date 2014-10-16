package com.choss.workflow.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WhenCreatingWorkflows {

    @Test
    public void canCreateWorkflow() {
        Workflow workflow = new Workflow();
        assertNotNull(workflow);
    }

    @Test
    public void canCreateAndAssign1StepWithName() {
        Workflow workflow = new Workflow();

        Step step = new Step("Complete Leave Request", "Leave Request", "Leave Request", "Approve Leave");
        workflow.addStep(step);

        assertEquals(workflow.getSteps().get(0).getOperation(), "Complete Leave Request");
    }

    @Test
    public void canCreateAndAssignMultipleStepsWithNames() {
        Workflow workflow = new Workflow();
        Step requestStep = new Step("Complete Leave Request", "Leave Request", "Leave Request", "Approve Leave");
        Step approvalStep = new Step("Complete Leave Request", "Leave Request", "Leave Request", "Approve Leave");

        workflow.addStep(requestStep);
        workflow.addStep(approvalStep);

        assertTrue(workflow.getSteps().size() == 2);
        assertEquals(workflow.getSteps().get(0).getOperation(), "Complete Leave Request");
        assertEquals(workflow.getSteps().get(1).getOperation(), "Complete Leave Request");
    }

    @Test
    public void canAssignStepWithInput() {
        Workflow workflow = new Workflow();
        Step requestStep = new Step("Complete Leave Request", "Leave Request", "Leave Request", "Approve Leave");

        workflow.addStep(requestStep);

        assertEquals(workflow.getSteps().get(0).getInput(), "Leave Request");
    }

    @Test
    public void canAssignStepWithOperation() {
        Workflow workflow = new Workflow();
        Step requestStep = new Step("Complete Leave Request", "Leave Request", "Leave Request", "Approve Leave");

        workflow.addStep(requestStep);

        assertEquals(workflow.getSteps().get(0).getOperation(), "Consider Leave");
    }

    @Test
    public void canAssignStepWithDownstreamOperation(){
        Workflow workflow = new Workflow();
        Step requestStep = new Step("Complete Leave Request", "Leave Request", "Leave Request", "Approve Leave");

        workflow.addStep(requestStep);

        assertEquals(workflow.getSteps().get(0).getDownstreamStep(), "Consider Leave");
    }

    @Test
    public void canAssignStepWithOutput() {
        Workflow workflow = new Workflow();
        Step requestStep = new Step("Complete Leave Request", "Leave Request", "Leave Request", "Approve Leave");

        workflow.addStep(requestStep);

        assertEquals(workflow.getSteps().get(0).getOutput(), "Leave Request");
    }
}
