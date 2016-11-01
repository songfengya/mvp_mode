package com.example.day37_dagger_butterknife_mvp_demo.dagger;

import com.example.day37_dagger_butterknife_mvp_demo.presenter.impl.GuidePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/11/1.
 */
@Module
public class AppModule {

    @Provides
  public GuidePresenter provideGuidePresent(){
      return  new GuidePresenter();
  }
}
