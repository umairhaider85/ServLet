package com.example.umair.servlet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Umair on 11/16/2016.
 */
public class PostAdapter extends ArrayAdapter<PostEntity>
{
    private Context context;
    PostEntity postEntity;
    private ArrayList<PostEntity> mPosts;

    public PostAdapter(Context context, int resource, ArrayList<PostEntity> posts){
        super(context, resource, posts);
        mPosts = posts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        postEntity = mPosts.get(position);


        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.list_item,null);

        TextView postNameTextView = (TextView) view.findViewById(R.id.post_name);
        TextView postDescriptionTextView = (TextView) view.findViewById(R.id.post_description);
        ImageView postImage = (ImageView) view.findViewById(R.id.post_image);

        postNameTextView.setText(postEntity.getmPostName());
        postDescriptionTextView.setText(postEntity.getmPostDescription());
        postImage.setImageResource(R.mipmap.ic_launcher);

        return view;
    }
}
