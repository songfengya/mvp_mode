package com.example.layzzweekend.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.layzzweekend.MainActivity;
import com.example.layzzweekend.R;
import com.example.layzzweekend.tools.LogPrint;

public class LocaluserLoginActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RadioGroup mRadioGroup_one;
    private RadioGroup mRadioGroup_two;
    private   boolean  isCheckSex;
    private  boolean isCheckLift;
    private String tip = "为了提供更好的服务，请您选择的性别和生活状态！";
    private ImageView mImageView_Back;
    private ImageView mImageView_Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localuser_login);
        mToolbar = (Toolbar) findViewById(R.id.login_localuser_toolbar);
        setSupportActionBar(mToolbar);
           initView();
    }

    private void initView() {
        mRadioGroup_one = (RadioGroup) findViewById(R.id.login_localuser_radiogroup);
        mRadioGroup_two = (RadioGroup) findViewById(R.id.login_localuser_radiogroup_two);
        mImageView_Back = (ImageView)mToolbar.findViewById(R.id.login_localuser_back_btn);
        mImageView_Next = (ImageView)mToolbar.findViewById(R.id.login_localuser_next_btn);
        setChange();
    }
    public  void click(View view){
        int id = view.getId();
        switch (id){
            case R.id.login_localuser_back_btn:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            break;
            case R.id.login_localuser_next_btn:
                LogPrint.doLogi(LocaluserLoginActivity.class,isCheckSex);
                LogPrint.doLogi(LocaluserLoginActivity.class,isCheckLift);
                if (isCheckLift && isCheckSex) {
            Intent intent2 = new Intent(this,HobbyChoseActivity.class);
            startActivity(intent2);
        }else {
            Toast.makeText(this,tip,Toast.LENGTH_SHORT).show();
        }
            break;
        }
    }
    private void setChange() {
        mRadioGroup_one.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                isCheckSex = true;
            }
        });
        mRadioGroup_two.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                isCheckLift = true;
            }
        });
//        mImageView_Back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LocaluserLoginActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//        mImageView_Next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LocaluserLoginActivity.this,HobbyChoseActivity.class);
//                startActivity(intent);
//            }
//        });
    }

}
