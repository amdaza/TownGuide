package io.keepcoding.townguide.navigator;

import android.content.Intent;

import io.keepcoding.townguide.activities.MainActivity;
import io.keepcoding.townguide.activities.ShopsActivity;

/**
 * Created by Alicia on 13/12/2016.
 */
public class Navigator {


    public static Intent navigateFromMainActivityToShopsActivity(final MainActivity mainActivity) {
        final Intent intent = new Intent(mainActivity, ShopsActivity.class);

        mainActivity.startActivity(intent);

        return intent;
    }
}
