package com.example.day36_mvc_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.day36_mvc_demo.ui.key.KeyUtils;
import com.example.day36_mvc_demo.view.IMainViewResult;
import com.example.day36_mvc_demo.been.MainBeen;
import com.example.day36_mvc_demo.model.Data_Model;
import com.example.day36_mvc_demo.ui.DetailActivity;

import java.util.List;

/**
 *  controller  控制器 作用：将model数据传递传递给view使用，控制数据的显示
 */
public class MainActivity extends AppCompatActivity implements IMainViewResult{
   private Data_Model data_model;
    private MainBeen mainBeen;
    private TextView mMain_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        mMain_txt = (TextView) findViewById(R.id.main_txt);
        mMain_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(KeyUtils.MainActivity.MAIN_Key,mainBeen.getList().get(0).getId());
                startActivity(intent);
            }
        });
    }
    private void initData() {
        data_model =new Data_Model(this);
        data_model.parserJson();
    }

    @Override
    public void getMainBeenReault(MainBeen mainBeen) {
        this.mainBeen = mainBeen;
        List<MainBeen.ListBean> list = mainBeen.getList();
        MainBeen.ListBean listBean = list.get(0);
        String gname = listBean.getGname();
        mMain_txt.setText(gname);
    }
}
