package com.mech;

import android.app.Application;
import android.content.Context;

/**
 * Created by Agustin on 31/7/2017.
 */

public class MechApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MechApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MechApplication.context;
    }
}
