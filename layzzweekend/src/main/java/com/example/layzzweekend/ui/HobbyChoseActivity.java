package com.example.layzzweekend.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageButton;

import com.example.layzzweekend.R;

import java.util.ArrayList;
import java.util.List;

public class HobbyChoseActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private GridView mGridView;
    private List<Integer> selectorList = new ArrayList<>();
    private List<String> typeList = new ArrayList<>();
    private MyGridViewAdapter myGridViewAdapter;
    private ImageButton mImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby_chose);
        mToolbar = (Toolbar) findViewById(R.id.hobbychose_toolbar);
        setSupportActionBar(mToolbar);
        initView();
        initDatas();
    }
    public void click(View view){
        int id = view.getId();
        switch (id) {
            case R.id.hobbychose_back_img:
                Intent intent = new Intent(this,LocaluserLoginActivity.class);
                startActivity(intent);
            break;
            case R.id.hobbychose_next_img:
                Intent intent2 = new Intent(this,ShowActivity.class);
                startActivity(intent2);
            break;
        }
    }
    private void initDatas() {
        selectorList.add(R.drawable.checkbox_hobby_zoubianyou_selector);
        selectorList.add(R.drawable.checkbox_hobby_jiuba_selector);
        selectorList.add(R.drawable.checkbox_hobby_yinyue_selector);
        selectorList.add(R.drawable.checkbox_hobby_xiju_selector);
        selectorList.add(R.drawable.checkbox_hobby_zhanlan_selector);
        selectorList.add(R.drawable.checkbox_hobby_meishi_selector);
        selectorList.add(R.drawable.checkbox_hobby_gouwu_selector);
        selectorList.add(R.drawable.checkbox_hobby_dianying_selector);
        selectorList.add(R.drawable.checkbox_hobby_juhui_selector);
        selectorList.add(R.drawable.checkbox_hobby_yundong_selector);
        selectorList.add(R.drawable.checkbox_hobby_gongyi_selector);
        selectorList.add(R.drawable.checkbox_hobby_shangye_selector);
        typeList.add("周边游");
        typeList.add("酒吧");
        typeList.add("音乐");
        typeList.add("戏剧");
        typeList.add("展览");
        typeList.add("美食");
        typeList.add("购物");
        typeList.add("电影");
        typeList.add("聚会");
        typeList.add("运动");
        typeList.add("公益");
        typeList.add("商业");
        myGridViewAdapter.notifyDataSetChanged();

    }

    private void initView() {
        mGridView = (GridView) findViewById(R.id.hobbychose_gridview);
        myGridViewAdapter = new MyGridViewAdapter(this);
        mGridView.setAdapter(myGridViewAdapter);
    }
    class MyGridViewAdapter extends BaseAdapter{
        private LayoutInflater myInflater;

        public MyGridViewAdapter(Context context) {
            this.myInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return selectorList == null ? 0 : selectorList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CheckBox checkBox = null;
            if (convertView == null) {
                convertView = myInflater.inflate(R.layout.hobbychose_gridview_item,parent,false);
                checkBox = (CheckBox) convertView.findViewById(R.id.hobbychose_gridview_item_box);
                convertView.setTag(checkBox);
            }else {
                checkBox = (CheckBox) convertView.getTag();
            }
            checkBox.setText(typeList.get(position));
            checkBox.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.checkbox_hobby_selector,selectorList.get(position),0,0);
            return convertView;
        }
    }
}
