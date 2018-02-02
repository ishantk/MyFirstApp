package com.auribises.myfirstapp;

import android.net.Uri;

/**
 * Created by ishantkumar on 02/02/18.
 */

public class Util {

    // DB Related Data
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Users.db";

    // Table Related Data
    public static final String TAB_NAME = "User";
    public static final String COL_ID = "_ID";
    public static final String COL_NAME = "NAME";
    public static final String COL_PHONE = "PHONE";
    public static final String COL_EMAIL = "EMAIL";

    // CREATE TABLE QUERY
    public static final String CREATE_TAB_QUERY = "create table User" +
            "(" +
            "_ID integer primary key autoincrement," +
            "NAME text," +
            "PHONE text," +
            "EMAIL text" +
            ")";

    public static final Uri USER_TAB_URI = Uri.parse("content://com.auribises.mycp/"+TAB_NAME);

}
