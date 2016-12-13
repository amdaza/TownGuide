package io.keepcoding.townguide.model;

/**
 * Created by Alicia on 13/12/2016.
 */
public interface IShopsUpdatable {
    void add(Shop shop);
    void delete(Shop shop);
    void edit(Shop newShop, long index);
}
