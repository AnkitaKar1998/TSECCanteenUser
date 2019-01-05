package com.example.ankita.tseccanteenuser;

import android.app.Application;

import com.firebase.client.Firebase;

public class TSECCanteenUser extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
