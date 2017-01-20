package org.sagebase.mpower;

import android.content.Intent;
import android.os.Bundle;

import org.researchstack.backbone.utils.LogExt;
import org.researchstack.skin.ui.MainActivity;

/**
 * Created by rianhouston on 12/13/16.
 */

public class SplashActivity extends org.researchstack.skin.ui.SplashActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDataReady() {
        super.onDataReady();
        // Init all notifications
//    sendBroadcast(new Intent(TaskAlertReceiver.ALERT_CREATE_ALL));
//
//    DataProvider.getInstance()
//            .initialize(this)
//            .compose(ObservableUtils.applyDefault())
//            .subscribe(response -> {
//
//              if(AppPrefs.getInstance(this).isOnboardingComplete() ||
//                      DataProvider.getInstance().isSignedIn(this)) {
//                launchMainActivity();
//              } else {
//                launchOnboardingActivity();
//              }
//
//              finish();
//            });
    }

    @Override
    protected void launchOnboardingActivity() {
        LogExt.i(getClass(), "launchOnboardingActivity()");
        startActivity(new Intent(this, MPowerOverviewActivity.class));
    }

    @Override
    protected void launchMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
