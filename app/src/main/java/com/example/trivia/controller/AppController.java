package com.example.trivia.controller;

import android.app.Application;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {
    private static AppController instance;
    private RequestQueue requestQueue;
    private ImageLoader ImageLoader; //This helps with loading images from the internet

    public static synchronized AppController getInstance() {
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
            // getApplicationContext() is key, it keeps you from
            // leaking the Activity or BroadcastReceiver if someone passes one in.
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}