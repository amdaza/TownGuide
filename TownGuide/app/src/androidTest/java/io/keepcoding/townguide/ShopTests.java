package io.keepcoding.townguide;

import android.test.AndroidTestCase;

import io.keepcoding.townguide.model.Shop;

/**
 * Created by Alicia on 18/12/2016.
 */


public class ShopTests extends AndroidTestCase {

    public static final String SHOP = "shop";
    public static final String ADDRESS = "ADDRESS";
    public static final String DESC = "DESC";
    public static final String URL = "URL";

    public void testCanCreateAShop() {
        // SUT -> System Under Test
        Shop sut = new Shop(0, SHOP);
        assertNotNull(sut);
    }

    public void testANewShopStoresDataCorrectly() {
        Shop sut = new Shop(10, SHOP);
        assertEquals(10, sut.getId());
        assertEquals(SHOP, sut.getName());
    }

    public void testANewShopStoresDataInPropertiesCorrectly() {
        Shop sut = new Shop(11, SHOP)
                .setAddress(ADDRESS)
                .setDescription(DESC)
                .setImageUrl(URL);

        assertEquals(sut.getAddress(), ADDRESS);
        assertEquals(sut.getDescription(), DESC);
        assertEquals(sut.getImageUrl(), URL);
    }
}
