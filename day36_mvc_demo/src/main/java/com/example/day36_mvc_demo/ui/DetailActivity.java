package com.example.day36_mvc_demo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.day36_mvc_demo.R;
import com.example.day36_mvc_demo.model.Data_Model;
import com.example.day36_mvc_demo.ui.key.KeyUtils;
import com.example.day36_mvc_demo.view.IDetailViewResult;

public class DetailActivity extends AppCompatActivity implements IDetailViewResult {

    private TextView mTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mTxt = (TextView) findViewById(R.id.detail_txt);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        String main_id = intent.getStringExtra(KeyUtils.MainActivity.MAIN_Key);
        Data_Model data_model = new Data_Model(this);
        data_model.detialJson(main_id);
    }

    @Override
    public void getDetailViewResult(String result) {
        mTxt.setText(result);
    }
}
