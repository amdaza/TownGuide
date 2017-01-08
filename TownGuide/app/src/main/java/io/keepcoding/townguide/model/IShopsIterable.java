package io.keepcoding.townguide.model;

import java.util.List;

/**
 * Created by Alicia on 13/12/2016.
 */
public interface IShopsIterable {
    public long size();
    public Shop get(long index);
    public List<Shop> allShops();
}
