package org.sagebase.mpower;

import android.content.Context;
import android.support.multidex.MultiDex;

import org.researchstack.skin.ResearchStack;
import org.sagebionetworks.bridge.android.BridgeApplication;
import org.sagebionetworks.bridge.researchstack.MPowerResearchStack;

/**
 * Created by TheMDP on 12/9/16.
 */

public class MainApplication extends BridgeApplication {

    MPowerResearchStack mPowerResearchStack;

    public void onCreate() {
        super.onCreate();

        mPowerResearchStack = new MPowerResearchStack(this);
        ResearchStack.init(this, mPowerResearchStack);
    }

    @Override
    protected void attachBaseContext(Context base)
    {
        // This is needed for android versions < 5.0 or you can extend MultiDexApplication
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
