package com.example.umair.servlet;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Umair on 11/16/2016.
 */
public class PostAdapter extends CursorAdapter
{
    private Context mContext;
    PostEntity postEntity;
    private ArrayList<PostEntity> mPosts;

    public PostAdapter(Context context, Cursor cursor){
        super(context, cursor, 0);
        mContext = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView postNameTextView = (TextView) view.findViewById(R.id.post_name);
        TextView postDescriptionTextView = (TextView) view.findViewById(R.id.post_description);
        ImageView postImage = (ImageView) view.findViewById(R.id.post_image);

        postNameTextView.setText(cursor.getString(cursor.getColumnIndex(MyDB.POST_TITLE)));
        postDescriptionTextView.setText(cursor.getString(cursor.getColumnIndex(MyDB.POST_EXPERT)));
        postImage.setImageResource(R.mipmap.ic_launcher);


    }

    @Override
    protected void onContentChanged() {
        Toast.makeText(mContext,"Updated data", Toast.LENGTH_SHORT).show();
        super.onContentChanged();
    }
}
