package com.example.day37_dagger_butterknife_mvp_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.day37_dagger_butterknife_mvp_demo.dagger.DaggerAppComponent;
import com.example.day37_dagger_butterknife_mvp_demo.model.been.SelectedBeen;
import com.example.day37_dagger_butterknife_mvp_demo.presenter.impl.GuidePresenter;
import com.example.day37_dagger_butterknife_mvp_demo.tools.LogUtils;
import com.example.day37_dagger_butterknife_mvp_demo.view.IGuideViewResult;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IGuideViewResult{
   @BindView(R.id.main_list) ListView mListView;
    @Inject
    GuidePresenter guidePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerAppComponent.create().inject(this);
        guidePresenter.runGuideModel(1);
    }

    @Override
    public void getGuideViewResult(SelectedBeen selectedBeen) {
        int code = selectedBeen.getCode();
        LogUtils.log(MainActivity.class,String.valueOf(code));
    }
}
