package io.keepcoding.townguide.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alicia on 13/12/2016.
 */

public class Shops implements IShopsIterable, IShopsUpdatable{

    List<Shop> shops;

    public static @NonNull Shops build(@NonNull final List<Shop> shopList) {
        Shops shops = new Shops(shopList);

        if (shopList == null) {
            shops.shops = new ArrayList<>();
        }

        return shops;
    }

    public static @NonNull Shops build(){
        return build(new ArrayList<Shop>());
    }

    private Shops(){}

    private Shops(List<Shop> shops){
        this.shops = shops;
    }

    @Override
    public long size() {
        return shops.size();
    }

    @Override
    public Shop get(long index) {
        return shops.get((int) index);
    }

    @Override
    public void add(Shop shop) {
        shops.add(shop);
    }

    @Override
    public void delete(Shop shop) {
        shops.remove(shop);
    }

    @Override
    public void edit(Shop newShop, long index) {
        shops.set((int) index, newShop);
    }
}
