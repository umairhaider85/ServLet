package com.example.umair.servlet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PostDisplayActivity extends AppCompatActivity {

    private PostAdapter mPostAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_category);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_post_display, new PostDisplayFragment())
                    .commit();
        }

        ArrayList<PostEntity> data = new ArrayList<PostEntity>();

        data.add(0,new PostEntity("Umair","Lorum ipsum aldfasdfds;l;fk"));
        data.add(1,new PostEntity("Abbas","Lorum ipsum aldfasdfds;l;fk"));
        data.add(2,new PostEntity("Rabie","Lorum ipsum aldfasdfds;l;fk"));
        data.add(3,new PostEntity("Zahid","Lorum ipsum aldfasdfds;l;fk"));
        data.add(4,new PostEntity("Wasif","Lorum ipsum aldfasdfds;l;fk"));

        mPostAdapter = new PostAdapter(this,R.layout.list_item,data);

        ListView postListView = (ListView) findViewById(R.id.listview_post_description);
        postListView.setAdapter(mPostAdapter);


    }
}
