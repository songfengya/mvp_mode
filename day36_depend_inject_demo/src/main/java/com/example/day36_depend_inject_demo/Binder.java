package com.example.day36_depend_inject_demo;

import android.app.Activity;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by Administrator on 2016/10/31.
 */
public class Binder {
    public static  void bind(Activity activity){
        Class<? extends Activity> aClass = activity.getClass();
        // 获得类的属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            BindView annotation = declaredField.getAnnotation(BindView.class);
            BindString annotation2 = declaredField.getAnnotation(BindString.class);
            if (annotation != null) {
                int value = annotation.value();
                View viewById = activity.findViewById(value);
                try {
                    declaredField.set(activity,viewById);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }else  if(annotation2 !=null){
                int id = annotation2.value();
                String string = activity.getResources().getString(id);
                try {
                    declaredField.set(activity,string);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }

        }

    }
    public static  void bind(Object object, View parent){
        Class<? extends Object> aClass = object.getClass();
        // 获得类的属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            BindView annotation = declaredField.getAnnotation(BindView.class);
//            BindString annotation2 = declaredField.getAnnotation(BindString.class);
            if (annotation != null) {
                int value = annotation.value();
                View viewById = parent.findViewById(value);
                try {
                    declaredField.set(object, viewById);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
//            }else  if(annotation2 !=null){
//                int id = annotation2.value();
//                String string = activity.getResources().getString(id);
//                try {
//                    declaredField.set(activity,string);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }

            }
        }

    }
}
