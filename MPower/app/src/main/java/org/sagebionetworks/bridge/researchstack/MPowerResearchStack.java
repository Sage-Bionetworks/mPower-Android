package org.sagebionetworks.bridge.researchstack;

import android.content.Context;

import net.sqlcipher.database.SQLiteDatabase;

import org.researchstack.backbone.storage.database.AppDatabase;
import org.researchstack.backbone.storage.database.sqlite.SqlCipherDatabaseHelper;
import org.researchstack.backbone.storage.database.sqlite.UpdatablePassphraseProvider;
import org.researchstack.backbone.storage.file.EncryptionProvider;
import org.researchstack.backbone.storage.file.FileAccess;
import org.researchstack.backbone.storage.file.PinCodeConfig;
import org.researchstack.backbone.storage.file.SimpleFileAccess;
import org.researchstack.backbone.storage.file.aes.AesProvider;
import org.researchstack.backbone.task.Task;
import org.researchstack.skin.AppPrefs;
import org.researchstack.skin.DataProvider;
import org.researchstack.skin.PermissionRequestManager;
import org.researchstack.skin.ResearchStack;
import org.researchstack.skin.ResourceManager;
import org.researchstack.skin.TaskProvider;
import org.researchstack.skin.UiManager;
import org.researchstack.skin.notification.NotificationConfig;
import org.researchstack.skin.notification.SimpleNotificationConfig;

/**
 * Created by TheMDP on 12/12/16.
 */

public class MPowerResearchStack extends ResearchStack {

    BridgeEncryptedDatabase mEncryptedDb;
    AesProvider mEncryptionProvider;

    MPowerResourceManager mResourceManager;
    MPowerUiManager mUiManager;

    MPowerDataProvider mDataProvider;

    SimpleFileAccess mFileAccess;
    PinCodeConfig mPinCodeConfig;

    TaskProvider mTaskProvider;

    SimpleNotificationConfig mNotificationConfig;

    MPowerPermissionRequestManager mPermissionManager;

    public MPowerResearchStack(Context context) {

        SQLiteDatabase.loadLibs(context);
        mEncryptedDb = new BridgeEncryptedDatabase(context,
                SqlCipherDatabaseHelper.DEFAULT_NAME,
                null,
                SqlCipherDatabaseHelper.DEFAULT_VERSION,
                new UpdatablePassphraseProvider());

        mFileAccess = new SimpleFileAccess();

        long autoLockTime = AppPrefs.getInstance(context).getAutoLockTime();
        mPinCodeConfig = new PinCodeConfig(autoLockTime);

        mEncryptionProvider = new AesProvider();

        mResourceManager = new MPowerResourceManager();

        mUiManager = new MPowerUiManager();

        mDataProvider = new MPowerDataProvider(context);

        mTaskProvider = new TaskProvider() {
            @Override
            public Task get(String taskId) {
                return null;
            }

            @Override
            public void put(String id, Task task) {

            }
        };

        mNotificationConfig = new SimpleNotificationConfig();

        mPermissionManager = new MPowerPermissionRequestManager();
    }

    @Override
    protected AppDatabase createAppDatabaseImplementation(Context context) {
        return mEncryptedDb;
    }

    @Override
    protected FileAccess createFileAccessImplementation(Context context) {
        return mFileAccess;
    }

    @Override
    protected PinCodeConfig getPinCodeConfig(Context context) {
        return mPinCodeConfig;
    }

    @Override
    protected EncryptionProvider getEncryptionProvider(Context context) {
        return mEncryptionProvider;
    }

    @Override
    protected ResourceManager createResourceManagerImplementation(Context context) {
        return mResourceManager;
    }

    @Override
    protected UiManager createUiManagerImplementation(Context context) {
        return mUiManager;
    }

    @Override
    protected DataProvider createDataProviderImplementation(Context context) {
        return mDataProvider;
    }

    @Override
    protected TaskProvider createTaskProviderImplementation(Context context) {
        return mTaskProvider;
    }

    @Override
    protected NotificationConfig createNotificationConfigImplementation(Context context) {
        return mNotificationConfig;
    }

    @Override
    protected PermissionRequestManager createPermissionRequestManagerImplementation(Context context) {
        return mPermissionManager;
    }
}
