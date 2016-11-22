package com.example.umair.servlet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Umair on 11/18/2016.
 */
public class DataBaseHandler extends SQLiteOpenHelper{

    private Context mContext;

    private static final String DATABASE_NAME = "POSTSDB";
    private static final int DATABASE_VERSION = 2;

    private static final String CREATE_POSTS_TABLE = "create table posts( menu_id integer primary key," +
            "post_id integer not null," +
            "post_image blob," +
            "post_title text," +
            "post_expert text," +
            "post_content text);";

    private static final String CREATE_VERSION_TABLE = "create table version( prime_id integer primary key," +
            "version_number integer not null);";

//  Constructor for initializing the DB connection
    public DataBaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_POSTS_TABLE);
        sqLiteDatabase.execSQL(CREATE_VERSION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}
}
