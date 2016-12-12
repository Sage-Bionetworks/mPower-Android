package org.sagebionetworks.bridge.researchstack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import org.researchstack.skin.PermissionRequestManager;

/**
 * Created by TheMDP on 12/12/16.
 */

public class MPowerPermissionRequestManager extends PermissionRequestManager {
    @Override
    public boolean hasPermission(Context context, String permissionId) {
        return false;
    }

    @Override
    public void onRequestNonSystemPermission(Activity activity, String id) {

    }

    @Override
    public boolean onNonSystemPermissionResult(Activity activity, int requestCode, int resultCode, Intent data) {
        return false;
    }
}
