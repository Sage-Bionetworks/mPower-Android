package org.sagebionetworks.bridge.researchstack;

import org.researchstack.backbone.result.StepResult;
import org.researchstack.backbone.result.TaskResult;
import org.researchstack.backbone.storage.database.AppDatabase;

import java.util.List;

/**
 * Created by TheMDP on 3/21/17.
 *
 * The MPowerEmptyAppDatabase is a no-op implementation of the AppDatabase,
 * since mPower does not use a sql database
 */

public class MPowerEmptyAppDatabase implements AppDatabase {

    public MPowerEmptyAppDatabase() {
        super();
    }

    @Override
    public void saveTaskResult(TaskResult result) {
        // no-op
    }

    @Override
    public TaskResult loadLatestTaskResult(String taskIdentifier) {
        // no-op
        return null;
    }

    @Override
    public List<TaskResult> loadTaskResults(String taskIdentifier) {
        // no-op
        return null;
    }

    @Override
    public List<StepResult> loadStepResults(String stepIdentifier) {
        // no-op
        return null;
    }

    @Override
    public void setEncryptionKey(String key) {
        // no-op
    }
}
