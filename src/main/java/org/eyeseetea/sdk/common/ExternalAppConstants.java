package org.eyeseetea.sdk.common;


import static org.eyeseetea.sdk.common.RequiredChecker.required;

import android.content.Context;

public class ExternalAppConstants {

    private static String mPackageName;
    private static String mAppDatabaseName;
    private static Context mContext;

    public static void init(Context context, String packageName, String appDatabaseName){
        mContext = required(context, "Context is required");
        mPackageName = required(packageName, "packageName is required");
        mAppDatabaseName = required(appDatabaseName, "appDatabaseName is required");
    }

    public static String getPackageName() {
        return mPackageName;
    }

    public static Context getContext() {
        return mContext;
    }
}
