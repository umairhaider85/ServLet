package com.example.umair.servlet;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PostDisplayActivity extends AppCompatActivity {

    private static PostAdapter mPostAdapter;
    private static Context mContext;
    static ArrayList<PostEntity> data;
    static MyDB db;
    static ListView postListView ;
    static Cursor dataCursor;


    @Override
    protected void onStart() {
        super.onStart();
//        Updating Activity title

   }

    private void initializeMetaDataInstances(){
        this.setTitle(getIntent().getStringExtra("category").toString());
        mContext = PostDisplayActivity.this;
        db = new MyDB(this);
        db.getDB();
        postListView = (ListView) findViewById(R.id.listview_post_description);
        data = new ArrayList<PostEntity>();
        updatePostsData();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_category);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_post_display, new PostDisplayFragment())
                    .commit();
        }
        initializeMetaDataInstances();

    }

    public static void updatePostsData(){

//        Adding dummy data
        dataCursor = db.selectRecords();

        mPostAdapter = new PostAdapter(mContext,dataCursor);

        postListView.setAdapter(mPostAdapter);

        postListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent postDetails = new Intent(mContext, WebViewActivity.class);
                String postNameForTitle = ((TextView) view.findViewById(R.id.post_name)).getText().toString();
                postDetails.putExtra("title",postNameForTitle);
                mContext.startActivity(postDetails);
                Toast.makeText(mContext,"I am clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void refreshPostsData(){
        mPostAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {


        super.onResume();
    }
}
