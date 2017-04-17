package org.sagebionetworks.bridge.researchstack;

import android.content.Context;

import org.researchstack.backbone.DataResponse;
import org.researchstack.backbone.result.TaskResult;
import org.sagebionetworks.bridge.android.manager.BridgeManagerProvider;

import rx.Observable;
import rx.functions.Action0;

import static org.sagebase.mpower.BuildConfig.CERTIFICATE_NAME;

/**
 * Created by TheMDP on 12/12/16.
 */

public class MPowerDataProvider extends BridgeDataProvider {

    public MPowerDataProvider() {
        // TODO give path to permission file for uploads
        super(BridgeManagerProvider.getInstance());
    }

    @Override
    public void processInitialTaskResult(Context context, TaskResult taskResult) {
        // TODO: what do we do with this method?
    }

    public Observable<DataResponse> signOut(Context context) {
        return super.signOut(context)
                .doOnCompleted(new Action0() {
                    @Override
                    public void call() {
                        MPowerPrefs.getInstance().clear();
                    }
                });

    }
}