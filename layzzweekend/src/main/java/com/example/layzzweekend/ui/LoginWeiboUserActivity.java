package com.example.layzzweekend.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.layzzweekend.MainActivity;
import com.example.layzzweekend.R;

public class LoginWeiboUserActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weibo_login);
        mToolbar = (Toolbar) findViewById(R.id.login_weibo_toolbar);
        setSupportActionBar(mToolbar);
        mImageView = (ImageView)mToolbar.findViewById(R.id.login_weibo_toolbar_icon_img);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginWeiboUserActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}