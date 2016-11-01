package com.example.day37_dagger_butterknife_mvp_demo.tools;

import android.util.Log;

/**
 * Created by Administrator on 2016/11/1.
 */
public class LogUtils {
    private static final String TAG = "androidxx";
    private static  boolean isPrint = true;
    public  static  void log(Class clazz, String string){
        if (isPrint) {
            Log.i(TAG, clazz.getName()+":"+string);
        }
    }
}
