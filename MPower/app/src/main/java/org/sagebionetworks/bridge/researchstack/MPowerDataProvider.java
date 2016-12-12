package org.sagebionetworks.bridge.researchstack;

import android.content.Context;

import org.researchstack.backbone.result.TaskResult;

/**
 * Created by TheMDP on 12/12/16.
 */

public class MPowerDataProvider extends BridgeDataProvider {

    // TODO: move to gradle.properties??
    static final String BASE_URL = "https://webservices.sagebridge.org/";
    static final String STUDY_ID = "parkinson";

    static final String USER_AGENT = System.getProperty("http.agent");

    public MPowerDataProvider(Context context) {
        super(context, BASE_URL, STUDY_ID, USER_AGENT);
    }

    @Override
    public void processInitialTaskResult(Context context, TaskResult taskResult) {
        // TODO: what do we do with this method?
    }
}
