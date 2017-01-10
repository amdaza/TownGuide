package io.keepcoding.townguide.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.keepcoding.townguide.R;
import io.keepcoding.townguide.adapters.ShopsAdapter;
import io.keepcoding.townguide.fragments.ShopsFragment;
import io.keepcoding.townguide.model.Shop;
import io.keepcoding.townguide.model.Shops;
import io.keepcoding.townguide.navigator.Navigator;

public class ShopsActivity extends AppCompatActivity {

    private ShopsFragment shopsFragment;
    private Shops shops;

    //Button shopsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);

        shopsFragment = (ShopsFragment) getSupportFragmentManager().findFragmentById(R.id.activity_shops_fragment_shops);

        shopsFragment.setOnElementClickListener(new ShopsAdapter.OnElementClick<Shop>() {

            @Override
            public void elementClicked(Shop shop, int position) {
                Navigator.navigateFromShopsActivityToDetailShopActivity(shop, ShopsActivity.this);
            }
        });
    }


}
