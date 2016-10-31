package com.example.layzzweekend.tools;

import android.util.Log;

/**
 * Created by Administrator on 2016/10/23.
 */
public class LogPrint {
    private static final String TAG = "androidxx";
    private static  boolean isOpen = true;

    public  static void doLogi(Class clazz, Object obj){
        if (isOpen) {
            Log.i(TAG, clazz+":"+obj);
        }
    }
}
