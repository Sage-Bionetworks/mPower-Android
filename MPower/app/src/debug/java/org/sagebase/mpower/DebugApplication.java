package org.sagebase.mpower;

import com.facebook.stetho.Stetho;

/**
 * Created by rianhouston on 2/13/17.
 */

public class DebugApplication extends MainApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                    .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                    .build());
    }
}
