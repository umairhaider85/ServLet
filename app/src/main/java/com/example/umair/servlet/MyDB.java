package com.example.umair.servlet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Umair on 11/18/2016.
 */
public class MyDB{

    private DataBaseHandler dbHelper;
    private static SQLiteDatabase database;

    Context mContext;

    public final static String POST_TABLE="posts"; // name of table

    public final static String MENU_ID="menu_id"; // id value for menu
    public final static String POST_ID="post_id"; // id value for post
    public final static String POST_IMAGE="post_image"; // image for the post
    public final static String POST_TITLE="post_title";
    public final static String POST_EXPERT="post_expert";
    public final static String POST_CONTENT="post_content";

    public final static String PRIME_ID="prime_id";  // name of employee
    public final static String VERSION_NUMBER="version_number";  // name of employee
    /**
     *
     * @param context
     */
    public MyDB(Context context){
        dbHelper = new DataBaseHandler(context);
        database = dbHelper.getWritableDatabase();
        mContext = context;
    }

    public long createRecords(int menu_id, int post_id, byte[] post_image, String post_title, String post_expert, String post_content){

        ContentValues values = new ContentValues();
        values.put(MENU_ID, menu_id);
        values.put(POST_ID, post_id);
        values.put(POST_IMAGE, post_image);
        values.put(POST_TITLE, post_title);
        values.put(POST_EXPERT, post_expert);
        values.put(POST_CONTENT, post_content);

        return database.insert(POST_TABLE, null, values);
    }

    public static Cursor selectRecords() {
        String[] cols = new String[] {POST_TITLE, POST_EXPERT, POST_CONTENT};
        Cursor cursor = database.query(true, POST_TABLE,cols,null
                , null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor; // iterate to get each value.
    }

    public SQLiteDatabase getDB(){
        return database;
    }
}