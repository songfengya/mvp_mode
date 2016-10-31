package com.example.layzzweekend;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.layzzweekend.ui.LocaluserLoginActivity;
import com.example.layzzweekend.ui.LoginWeiboUserActivity;
import com.example.layzzweekend.ui.LoginWeixinUserActivity;
import com.example.layzzweekend.ui.ShowActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TextView mTitle_txt;
    private TextView mDecription_txt;
    private List<Integer> listPath = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private List<String> descriptionList = new ArrayList<>();
    private MyAdapter myAdapter;
    private int current = 0;
//    private Button mWeibo_btn;
//    private Button mWeixin_btn;
//    private Button mBottom_btn;
   private Handler handler = new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        int index = mViewPager.getCurrentItem();
        mViewPager.setCurrentItem(index+1);
        sendEmptyMessageDelayed(1,3000);
    };
};
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPreference();
        setContentView(R.layout.activity_main);
        initView();
        initDatas();
    }

    private void initPreference() {
     preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirst = preferences.getBoolean("isFirst", true);
        if (isFirst){
            SharedPreferences.Editor edit = preferences.edit();
            edit.putBoolean("isFirst", false);
            edit.apply();
        }else {
//             跳转到主界面的第一个界面
            Intent intent = new Intent(this, ShowActivity.class);
            startActivity(intent);
            finish();
        }

    }

    private void initDatas() {
        listPath.add(R.drawable.pic1);
        listPath.add(R.drawable.pic2);
        listPath.add(R.drawable.pic3);
        listPath.add(R.drawable.pic4);
        myAdapter.notifyDataSetChanged();
        handler.sendEmptyMessage(1);
        titleList.add("闭目");
        descriptionList.add("难掩喜悦与期待");
        titleList.add("睁眼");
        descriptionList.add("因为你心因所动");
        titleList.add("启程");
        descriptionList.add("只因追寻你所爱");
        titleList.add("我们");
        descriptionList.add("做最了解你的人");


    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        mTitle_txt = (TextView) findViewById(R.id.main_title);
        mDecription_txt = (TextView) findViewById(R.id.main_description);
//        mWeibo_btn = (Button) findViewById(R.id.main_weibo_btn);
//        mWeixin_btn = (Button) findViewById(R.id.mian_weixin_btn);
//        mBottom_btn = (Button) findViewById(R.id.main_bottom_btn);
        myAdapter = new MyAdapter(this);
        mViewPager.setAdapter(myAdapter);
        mViewPager.setCurrentItem(Integer.MAX_VALUE/2);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
             mTitle_txt.setText(titleList.get(position%4));
             mDecription_txt.setText(descriptionList.get(position%4));
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 对mainactivity 里面的三个button做监听事件分发
     * @param view
     */
    public void click(View view){
        int id = view.getId();
        switch (id) {
            case R.id.main_weibo_btn:
               Intent intent = new Intent(this, LoginWeiboUserActivity.class);
                startActivity(intent);
            break;
            case R.id.mian_weixin_btn:
                Intent intent2 = new Intent(this, LoginWeixinUserActivity.class);
                startActivity(intent2);
                break;
            case R.id.main_bottom_btn:
                Intent intent3 = new Intent(this, LocaluserLoginActivity.class);
                startActivity(intent3);
                break;
        }
    }
    class MyAdapter extends PagerAdapter{
        private LayoutInflater myInflater;
        public MyAdapter(Context context) {
            this.myInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = (ImageView) myInflater.inflate(R.layout.main_load_imageview, null);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(listPath.get(position%4));
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
