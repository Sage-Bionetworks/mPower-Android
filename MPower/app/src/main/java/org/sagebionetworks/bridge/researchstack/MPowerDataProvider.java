package org.sagebionetworks.bridge.researchstack;

import android.content.Context;

import org.researchstack.backbone.ResourcePathManager;
import org.researchstack.backbone.result.TaskResult;

import static org.sagebase.mpower.BuildConfig.BRIDGE_URL;
import static org.sagebase.mpower.BuildConfig.STUDY_ID;

/**
 * Created by TheMDP on 12/12/16.
 */

public class MPowerDataProvider extends BridgeDataProvider {

    static final String USER_AGENT = System.getProperty("http.agent");

    public MPowerDataProvider(Context context) {
        // TODO give path to permission file for uploads
        // TODO add path to pem file
        super(BRIDGE_URL, STUDY_ID, USER_AGENT,
                new ResourcePathManager.Resource(ResourcePathManager.Resource.TYPE_HTML, "", ""));
    }

    @Override
    public void processInitialTaskResult(Context context, TaskResult taskResult) {
        // TODO: what do we do with this method?
    }
}
