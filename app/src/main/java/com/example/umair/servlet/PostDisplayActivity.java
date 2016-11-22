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

    private PostAdapter mPostAdapter;
    private Context context;
    ArrayList<PostEntity> data;
    MyDB db;

    @Override
    protected void onStart() {
        super.onStart();
//        Updating Activity title
        this.setTitle(getIntent().getStringExtra("category").toString());

        db = new MyDB(this);
        db.getDB();
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
        data = new ArrayList<PostEntity>();
//        Adding dummy data
         Cursor getDataCursor = db.selectRecords();

        if (getDataCursor.moveToFirst()){
            while(!getDataCursor.isAfterLast()){
                String title = getDataCursor.getString(getDataCursor.getColumnIndex(MyDB.POST_TITLE));
                String expert = getDataCursor.getString(getDataCursor.getColumnIndex(MyDB.POST_EXPERT));
                data.add(new PostEntity(title,expert));
                // do what ever you want here
                getDataCursor.moveToNext();
            }
        }
        getDataCursor.close();

        mPostAdapter = new PostAdapter(this,R.layout.list_item,data);
        final ListView postListView = (ListView) findViewById(R.id.listview_post_description);
        postListView.setAdapter(mPostAdapter);
        context = getApplication().getApplicationContext();
        postListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent postDetails = new Intent(context, WebViewActivity.class);
                String postNameForTitle = ((TextView) view.findViewById(R.id.post_name)).getText().toString();
                postDetails.putExtra("title",postNameForTitle);
                startActivity(postDetails);
                Toast.makeText(context,"I am clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
