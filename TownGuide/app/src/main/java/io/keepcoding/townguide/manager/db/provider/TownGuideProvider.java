package io.keepcoding.townguide.manager.db.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import io.keepcoding.townguide.model.Shop;
import io.keepcoding.townguide.model.db.ShopDAO;

/**
 * Created by Alicia on 15/01/2017.
 */

public class TownGuideProvider extends ContentProvider {

    public static final String TOWNGUIDE_PROVIDER = "io.keepcoding.townguide.provider";

    public static final Uri SHOPS_URI = Uri.parse("content://" + TOWNGUIDE_PROVIDER + "/shops");

    // Create the constants used to differentiate between the different URI requests.
    private static final int ALL_SHOPS = 1;
    private static final int SINGLE_SHOP = 2;

    private static final UriMatcher uriMatcher;
    // Populate the UriMatcher object,
    // where a URI ending in ‘elements’ will correspond to a request for all items,
    // and ‘elements/[rowID]’ represents a single row.
    static {
        // Static block code
        // Will execute on import (just once), when class is loaded in memory
        // Usually, used to initialize static attributes

        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        // content://io.keepcoding.madridguide.provider/shops
        uriMatcher.addURI(TOWNGUIDE_PROVIDER, "shops", ALL_SHOPS);
        // content://io.keepcoding.madridguide.provider/shops/363
        uriMatcher.addURI(TOWNGUIDE_PROVIDER, "shops/#", SINGLE_SHOP);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        ShopDAO dao = new ShopDAO(getContext());

        Cursor cursor = null;
        switch (uriMatcher.match(uri)) {
            case SINGLE_SHOP :
                String rowID = uri.getPathSegments().get(1);
                cursor = dao.queryCursor(Long.parseLong(rowID));
                break;
            case ALL_SHOPS:
                cursor = dao.queryCursor();
                break;
            default: break;
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        String type = null;

        switch (uriMatcher.match(uri)) {
            case SINGLE_SHOP :
                type = "vnd.android.cursor.item/vnd.io.keepcoding.madridguide.provider";
                break;
            case ALL_SHOPS:
                type = "vnd.android.cursor.dir/vnd.io.keepcoding.madridguide.provider";
                break;
            default:
                break;
        }

        return type;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        // content://io.keepcoding.madridguide.provider/shops

        ShopDAO dao = new ShopDAO(getContext());

        Shop shop = ShopDAO.getShopFromContentValues(contentValues);

        long id = dao.insert(shop);
        if (id == -1) {
            return null;
        }

        // content://io.keepcoding.madridguide.provider/shops/5353

        // Construct and return the URI of the newly inserted row.
        Uri insertedUri = null;
        switch (uriMatcher.match(uri)) {
            case ALL_SHOPS:
                insertedUri = ContentUris.withAppendedId(SHOPS_URI, id);
                break;
            default:
                break;
        }

        // Notify any observers of the change in the data set.
        getContext().getContentResolver().notifyChange(uri, null);
        getContext().getContentResolver().notifyChange(insertedUri, null);

        return insertedUri;
    }

    @Override
    public int delete(Uri uri, String where, String[] whereSelection) {
        // content://io.keepcoding.madridguide.provider/shops/72
        // content://io.keepcoding.madridguide.provider/activity/57

        ShopDAO dao = new ShopDAO(getContext());
        int deleteCount = 0;

        // If this is a row URI, limit the deletion to the specified row.
        switch (uriMatcher.match(uri)) {
            case SINGLE_SHOP:
                String rowID = uri.getPathSegments().get(1);
                deleteCount = dao.delete(Long.parseLong(rowID));
                break;
            case ALL_SHOPS:
                dao.deleteAll();
                break;
            default:
                break;
        }

        // Notify any observers of the change in the data set.
        getContext().getContentResolver().notifyChange(uri, null);

        // Return the number of deleted items.
        return deleteCount;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
