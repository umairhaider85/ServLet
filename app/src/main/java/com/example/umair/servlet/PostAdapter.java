package com.example.umair.servlet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Umair on 11/16/2016.
 */
public class PostAdapter extends ArrayAdapter<PostEntity>
{
    private Context context;
    private ArrayList<PostEntity> posts;

    public PostAdapter(Context context, int resource, ArrayList<PostEntity> posts){
        super(context, resource, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PostEntity postEntity = posts.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item,null);

        TextView postNameTextView = (TextView) view.findViewById(R.id.person_name);
        TextView postDescriptionTextView = (TextView) view.findViewById(R.id.person_description);

        postNameTextView.setText(postEntity.getmPostName());
        postDescriptionTextView.setText(postEntity.getmPostDescription());

        return view;
    }
}
