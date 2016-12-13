package io.keepcoding.townguide;

import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by Alicia on 13/12/2016.
 */

public class TownGuideApp extends Application {

    private static WeakReference<Context> appContext;

    @Override
    public void onCreate() {
        super.onCreate();

        // Init your app

        appContext = new WeakReference<>(getApplicationContext());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public static Context getAppContext(){
        return  appContext.get();
    }
}
