package io.keepcoding.townguide.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import io.keepcoding.townguide.R;
import io.keepcoding.townguide.adapters.ShopsAdapter;
import io.keepcoding.townguide.fragments.ShopsFragment;
import io.keepcoding.townguide.model.Shop;
import io.keepcoding.townguide.model.Shops;
import io.keepcoding.townguide.model.db.ShopDAO;
import io.keepcoding.townguide.navigator.Navigator;

public class ShopsActivity extends AppCompatActivity {

    private ShopsFragment shopsFragment;
    //private Shops shops;

    //Button shopsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);

        shopsFragment = (ShopsFragment) getSupportFragmentManager().findFragmentById(R.id.activity_shops_fragment_shops);

        //Shops shops = getShops();

        //shopsFragment.setShops(shops);

        shopsFragment.setOnElementClickListener(new ShopsAdapter.OnElementClick<Shop>() {

            @Override
            public void elementClicked(Shop shop, int position) {
                Navigator.navigateFromShopsActivityToDetailShopActivity(shop, ShopsActivity.this);
            }
        });
    }
/*
    private Shops getShops() {
        ShopDAO dao = new ShopDAO(this);

        List<Shop> shopList = dao.query();

        return Shops.build(shopList);
    }
    */
    private void loadShops() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                //ShopDAO dao = new ShopDAO(this);
                ShopDAO dao = new ShopDAO(getBaseContext());

                final List<Shop> shopList = dao.query();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Shops shops = Shops.build(shopList);

                        // DON'T DO THIS IN BACKGROUND
                        shopsFragment.setShops(shops);

                    }
                });
            }
        });
    }



}
