package io.keepcoding.townguide.model;

import java.util.List;

/**
 * Created by Alicia on 13/12/2016.
 */

public class Shops implements IShopsIterable, IShopsUpdatable{

    List<Shop> shops;

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
