package com.example.umair.servlet;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * Created by Umair on 11/20/2016.
 */
public class AuthService extends Service {

    // Instance field that stores the authenticator object
    private Authenticator mAuthenticator;
    @Override
    public void onCreate() {
        // Create a new authenticator object
        mAuthenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return super.getPasswordAuthentication();
            }
        };
    }
    /*
     * When the system binds to this Service to make the RPC call
     * return the authenticator's IBinder.
     */
    @Override
    public IBinder onBind(Intent intent) {
return null;
    }
}
