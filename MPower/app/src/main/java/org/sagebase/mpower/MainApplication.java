package org.sagebase.mpower;

import android.Manifest;
import android.app.Application;
import android.os.Build;

/**
 * Created by TheMDP on 12/9/16.
 */

public class MainApplication extends Application {

    public static final String PERMISSION_NOTIFICATIONS = "mPower.permission.NOTIFICATIONS";

    public void onCreate() {
        super.onCreate();
//-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
        // Init RS Singleton
        //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*

       // ResearchStack.init(this, new SampleResearchStack());

        //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
        // Init permission objects
        //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*

//        // If Build is M or >, add needed permissions
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
//        {
//            PermissionRequestManager.PermissionRequest location = new PermissionRequestManager.PermissionRequest(Manifest.permission.ACCESS_FINE_LOCATION,
//                    R.drawable.rss_ic_location_24dp,
//                    R.string.rss_permission_location_title,
//                    R.string.rss_permission_location_desc);
//            location.setIsBlockingPermission(true);
//            location.setIsSystemPermission(true);
//
//            PermissionRequestManager.getInstance().addPermission(location);
//        }
//
//        // We have some unique permissions that tie into Settings. You will need
//        // to handle the UI for this permission along w/ storing the result.
//        PermissionRequestManager.PermissionRequest notifications =
//                new PermissionRequestManager.PermissionRequest(
//                        PERMISSION_NOTIFICATIONS,
//                        R.drawable.rss_ic_notification_24dp,
//                        R.string.rss_permission_notification_title,
//                        R.string.rss_permission_notification_desc
//                );
//
//        PermissionRequestManager.getInstance().addPermission(notifications);
    }

    // TODO: why are they doing multidex?  is this needed?  Too many libraries?
//
//    @Override
//    protected void attachBaseContext(Context base)
//    {
//        // This is needed for android versions < 5.0 or you can extend MultiDexApplication
//        super.attachBaseContext(base);
//        MultiDex.install(this);
//    }
}
