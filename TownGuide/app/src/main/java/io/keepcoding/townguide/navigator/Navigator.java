package io.keepcoding.townguide.navigator;

import android.content.Intent;

import io.keepcoding.townguide.activities.MainActivity;
import io.keepcoding.townguide.activities.ShopDetailActivity;
import io.keepcoding.townguide.activities.ShopsActivity;
import io.keepcoding.townguide.model.Shop;
import io.keepcoding.townguide.utils.Constants;

/**
 * Created by Alicia on 13/12/2016.
 */
public class Navigator {

    public static Intent navigateFromMainActivityToShopsActivity(final MainActivity mainActivity) {
        final Intent intent = new Intent(mainActivity, ShopsActivity.class);

        mainActivity.startActivity(intent);

        return intent;
    }

    public static Intent navigateFromShopsActivityToDetailShopActivity(Shop shop, final ShopsActivity shopsActivity) {
        final Intent intent = new Intent(shopsActivity, ShopDetailActivity.class);

        intent.putExtra(Constants.INTENT_KEY_DETAIL_SHOP, shop);

        shopsActivity.startActivity(intent);

        return intent;
    }
}
