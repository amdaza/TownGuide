package io.keepcoding.townguide;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.test.AndroidTestCase;

import io.keepcoding.townguide.manager.db.DBConstants;
import io.keepcoding.townguide.manager.db.provider.TownGuideProvider;
import io.keepcoding.townguide.model.Shop;
import io.keepcoding.townguide.model.db.ShopDAO;

/**
 * Created by Alicia on 15/01/2017.
 */

public class TownGuideProviderTests extends AndroidTestCase {

    public void testQueryAllShops() {
        ContentResolver cr = getContext().getContentResolver();

        Cursor c = cr.query(TownGuideProvider.SHOPS_URI, DBConstants.ALL_COLUMNS, null, null, null);
        assertNotNull(c);
    }

    public void testInsertAShop() {
        final ContentResolver cr = getContext().getContentResolver();

        final Cursor beforeCursor = cr.query(TownGuideProvider.SHOPS_URI, DBConstants.ALL_COLUMNS, null, null, null);
        final int beforeCount = beforeCursor.getCount();

        final Shop shop = new Shop(1, "Little shop of horrors!");
        final Uri insertedUri = cr.insert(TownGuideProvider.SHOPS_URI, ShopDAO.getContentValues(shop));
        assertNotNull(insertedUri);

        final Cursor afterCursor = cr.query(TownGuideProvider.SHOPS_URI, DBConstants.ALL_COLUMNS, null, null, null);
        final int afterCount = afterCursor.getCount();

        assertEquals(beforeCount + 1, afterCount);
    }

}
