package io.keepcoding.townguide.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import io.keepcoding.townguide.R;
import io.keepcoding.townguide.adapters.ShopsAdapter;
import io.keepcoding.townguide.fragments.ShopsFragment;
import io.keepcoding.townguide.manager.db.DBConstants;
import io.keepcoding.townguide.model.Shop;
import io.keepcoding.townguide.model.Shops;
import io.keepcoding.townguide.model.db.ShopDAO;
import io.keepcoding.townguide.navigator.Navigator;

public class ShopsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

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

    private Shops getShops() {
        ShopDAO dao = new ShopDAO(this);

        List<Shop> shopList = dao.query();

        return Shops.build(shopList);
    }


    // Cursor Loaders using Content Provider

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader loader = new CursorLoader(this,
                MadridGuideProvider.SHOPS_URI,
                DBConstants.ALL_COLUMNS,            // projection
                null,                               // where
                null,                               // where fields
                null                                // order
        );

        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        final Shops shops = ShopDAO.getShops(data);

        shopsFragment.setListener(new OnElementClick<Shop>() {
            @Override
            public void clickedOn(@NonNull Shop shop, int position) {
                Navigator.navigateFromShopsActivityToShopDetailActivity(ShopsActivity.this, shop);
            }
        });

        shopsFragment.setShops(shops);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private void loadShops() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                //ShopDAO dao = new ShopDAO(this);
                final ShopDAO dao = new ShopDAO(getBaseContext());

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
