package com.example.day36_mvc_demo.Tools;

import android.util.Log;

/**
 * Created by Administrator on 2016/10/31.
 */
public class LogUtils {
    private static final String TAG = "androidxx";
    private static boolean isOpen =true;

    public  static void log(Class clazz, String string){
        if (isOpen) {
            Log.i(TAG,clazz.getName()+":"+string);
        }

    }
}
