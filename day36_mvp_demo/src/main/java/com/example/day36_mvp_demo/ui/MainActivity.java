package com.example.day36_mvp_demo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.day36_mvp_demo.R;
import com.example.day36_mvp_demo.been.GiftBeen;
import com.example.day36_mvp_demo.presenter.Presenter;
import com.example.day36_mvp_demo.view.IMainView;

import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 *  mvp View activity+layout 布局文件
 */
public class MainActivity extends AppCompatActivity implements IMainView{
   @BindView(R.id.main_txt)
    private TextView mTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Presenter presenter =new Presenter(this);
        presenter.doSomeThing(1);
        mTxt = (TextView) findViewById(R.id.main_txt);
    }

    @Override
    public void getMainBeenResult(GiftBeen giftBeen) {
        List<GiftBeen.ListBean> list = giftBeen.getList();
        GiftBeen.ListBean listBean = list.get(0);
        String gname = listBean.getGname();
        mTxt.setText(gname);
    }
}
