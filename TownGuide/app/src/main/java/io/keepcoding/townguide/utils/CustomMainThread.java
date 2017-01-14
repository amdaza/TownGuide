package io.keepcoding.townguide.utils;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Alicia on 14/01/2017.
 *
 * Custom Main Thread to use in UI async calls
 * (instead of create it in every call)
 */

public class CustomMainThread {
    public static void run(Runnable codeToRun) {
        Handler uiHandler = new Handler(Looper.getMainLooper());

        uiHandler.post(codeToRun);
    }
}
