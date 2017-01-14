package io.keepcoding.townguide.interactors;

import android.content.Context;

import java.util.List;

import io.keepcoding.townguide.model.Shop;
import io.keepcoding.townguide.model.Shops;
import io.keepcoding.townguide.model.db.ShopDAO;
import io.keepcoding.townguide.utils.CustomMainThread;

/**
 * Created by Alicia on 14/01/2017.
 */

public class GetAllShopsFromLocalCacheInteractor {

    public interface  OnGetAllShopsFromLocalCacheInteractorCompletion {
        public void completion(Shops shops);
    }

    public void execute(final Context context, final OnGetAllShopsFromLocalCacheInteractorCompletion completion) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ShopDAO dao = new ShopDAO(context);

                List<Shop> shopList = dao.query();
                final Shops shops = Shops.build(shopList);

                CustomMainThread.run(new Runnable() {
                    @Override
                    public void run() {
                        completion.completion(shops);
                    }
                });


            }
        }).start();
    }
}
