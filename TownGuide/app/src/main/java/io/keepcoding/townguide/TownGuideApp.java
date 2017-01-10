package io.keepcoding.townguide;

import android.app.Application;
import android.content.Context;

import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;

import io.keepcoding.townguide.model.Shop;
import io.keepcoding.townguide.model.db.ShopDAO;

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

        // Insert test data in DB
        insertTestData();


        Picasso.with(getApplicationContext()).setLoggingEnabled(true);
        Picasso.with(getApplicationContext()).setIndicatorsEnabled(true);
    }

    private void insertTestData() {
        ShopDAO dao = new ShopDAO(getApplicationContext());
        for (int i = 0; i < 100; i++) {
            Shop shop = new Shop(i, "Tienda número " + i);
            shop.setLogoImgUrl("http://sfgoodwill.org/wp-content/wptouch-data/1/icons/custom/gw_icon_mobile_shop-online.png");
            dao.insert(shop);
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public static Context getAppContext(){
        return  appContext.get();
    }
}
