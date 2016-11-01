package com.example.day37_dagger_butterknife_mvp_demo.dagger;

import com.example.day37_dagger_butterknife_mvp_demo.MainActivity;

import dagger.Component;

/**
 * Created by Administrator on 2016/11/1.
 */
@Component(modules = {AppModule.class})
public interface AppComponent {
    void  inject(MainActivity mainActivity);
}
