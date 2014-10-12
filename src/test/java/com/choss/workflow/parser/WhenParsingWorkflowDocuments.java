package com.choss.workflow.parser;

import com.choss.workflow.model.Operation;
import com.choss.workflow.model.Workflow;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WhenParsingWorkflowDocuments {

    @Test
    public void canCreateWorkflow() {
        Workflow workflow = new Workflow();
        assertNotNull(workflow);
    }

    @Test
    public void canCreateAndAssign1OperationWithName() {
        Workflow workflow = new Workflow();

        Operation operation = new Operation("Complete Leave Request", "Leave Request");
        workflow.addOperation(operation);

        assertEquals(workflow.getOperations().get(0), "Fill Leave Request");
    }

    @Test
    public void canCreateAndAssignMultipleOperationsWithNames() {
        Workflow workflow = new Workflow();
        Operation requestOperation = new Operation("Complete Leave Request", "Leave Request");
        Operation approvalOperation = new Operation("Leave Approval", "Completed Leave Request");

        workflow.addOperation(requestOperation);
        workflow.addOperation(approvalOperation);

        assertTrue(workflow.getOperations().size() == 2);
        assertEquals(workflow.getOperations().get(0).getName(), "Complete Leave Request");
        assertEquals(workflow.getOperations().get(1).getName(), "Leave Approval");
    }

    @Test
    public void canAssignOperationsWithInputType() {
        Workflow workflow = new Workflow();
        Operation requestOperation = new Operation("Complete Leave Request", "Leave Request Data");

        workflow.addOperation(requestOperation);

        assertEquals(workflow.getOperations().get(0).getInputType(), "Leave Request Data");
    }

    //TODO Think about how I can turn the input type name into an actual class.
    //TODO Will probably need to have a map of names to classes somewhere which may
    //TODO mean that further definition of input types is needed.
}
