package com.example.day36_depend_inject_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 依赖注入
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_txt)
    TextView mMain_txt;
    @BindView(R.id.main_show_txt2)
    TextView mMain_show_txt;
    @BindString(R.string.name)
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mMain_txt = (TextView) findViewById(R.id.main_txt);
//        mMain_txt.setText("这是依赖注入的demo");
        Binder binder = new Binder();
        binder.bind(this);
        mMain_txt.setText("这是张三");
        mMain_show_txt.setText(name);
    }
}
