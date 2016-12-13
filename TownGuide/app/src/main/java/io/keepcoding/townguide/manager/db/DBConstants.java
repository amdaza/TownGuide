package io.keepcoding.townguide.manager.db;

/**
 * Created by Alicia on 14/12/2016.
 */
public class DBConstants {

    public static final String TABLE_SHOP = "SHOP";


    // Table field constants
    public static final String KEY_SHOP_ID = "_id";
    public static final String KEY_SHOP_NAME = "NAME";
    public static final String KEY_SHOP_IMAGE_URL = "IMAGE_URL";
    public static final String KEY_SHOP_LOGO_IMAGE_URL = "IMAGE_UR";

    // Table field constants
    public static final String KEY_SHOP_ADDRESS = "ADDRESS";
    public static final String KEY_SHOP_URL = "URL";
    public static final String KEY_SHOP_LATITUDE = "LATITUDE";
    public static final String KEY_SHOP_LONGITUDE = "LONGITUDE";
    public static final String KEY_SHOP_DESCRIPTION = "DESCRIPTION";


    public static final String SQL_SCRIPT_CREATE_SHOP_TABLE =
            "create table " + TABLE_SHOP + "( "
                    + KEY_SHOP_ID + " integer primary key autoincrement, "
                    + KEY_SHOP_NAME + " text not null,"
                    + KEY_SHOP_IMAGE_URL + " text, "
                    + KEY_SHOP_LOGO_IMAGE_URL + " text, "
                    + KEY_SHOP_ADDRESS + " text,"
                    + KEY_SHOP_URL + " text,"
                    + KEY_SHOP_LATITUDE + " real,"
                    + KEY_SHOP_LONGITUDE + " real, "
                    + KEY_SHOP_DESCRIPTION + " text"
                    + ");";

    public static final String[] CREATE_DATABASE = {
            SQL_SCRIPT_CREATE_SHOP_TABLE
    };
}
