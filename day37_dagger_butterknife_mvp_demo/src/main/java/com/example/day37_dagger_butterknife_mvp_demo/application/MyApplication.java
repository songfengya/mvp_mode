package com.example.day37_dagger_butterknife_mvp_demo.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/11/1.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
