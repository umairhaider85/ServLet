package com.example.umair.servlet;

/**
 * Created by Umair on 11/16/2016.
 */
public class PostEntity {

    private String mPostName;
    private String mPostDescription;

    public PostEntity(String postName, String postDescription) {

        mPostName = postName;
        mPostDescription = postDescription;

    }

    public String getmPostName() {
        return mPostName;
    }

    public String getmPostDescription() {
        return mPostDescription;
    }

}
