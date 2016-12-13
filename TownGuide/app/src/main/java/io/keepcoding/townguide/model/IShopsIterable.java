package io.keepcoding.townguide.model;

import java.util.List;

/**
 * Created by Alicia on 13/12/2016.
 */
public interface IShopsIterable {
    long size();
    Shop get(long index);
    List<Shop> allShops;
}
