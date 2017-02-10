package org.sagebionetworks.bridge.researchstack;

import android.content.Context;

import org.researchstack.backbone.result.TaskResult;
import org.sagebionetworks.bridge.android.manager.BridgeManagerProvider;

import static org.sagebase.mpower.BuildConfig.CERTIFICATE_NAME;

/**
 * Created by TheMDP on 12/12/16.
 */

public class MPowerDataProvider extends BridgeDataProvider {

    public MPowerDataProvider(Context context) {
        // TODO give path to permission file for uploads
        super(BridgeManagerProvider.getInstance(),
                new MPowerResourceManager.PemResource(CERTIFICATE_NAME));
    }

    @Override
    public void processInitialTaskResult(Context context, TaskResult taskResult) {
        // TODO: what do we do with this method?
    }
}