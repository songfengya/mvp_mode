package com.example.layzzweekend.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.example.layzzweekend.R;
import com.example.layzzweekend.been.CityBeen;
import com.example.layzzweekend.presenter.CityPresenter;
import com.example.layzzweekend.presenter.UserPresenter;
import com.example.layzzweekend.tools.LogPrint;
import com.example.layzzweekend.view.CustomGridView;
import com.example.layzzweekend.view.CustomListView;
import com.example.layzzweekend.view.ICityBeenResult;

import java.util.ArrayList;
import java.util.List;

public class ChooseCityActivity extends AppCompatActivity implements ICityBeenResult{

    private TextView mCurrentCity;
    private TextView mLastCity_one_txt;
    private TextView mLastCity_two_txt;
    private TextView mLastCity_three_txt;
    private CustomGridView mGridView;
    private CustomListView mListView;
    private List<CityBeen.ResultBean> dataList = new ArrayList<>();
    private List<CityBeen.ResultBean.CityListBean> hotcity_list= new ArrayList<>();
    private MyGridViewAdapter myGridViewAdapter;
    private String currentcityname;
    private  List<String> tatalList = new ArrayList<>();
    private MyListViewAdapter myListViewAdapter;
    private ScrollView mScrollView;
    private TextView mScroll_txt;
   private SharedPreferences preferences;
    private  SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_city);
         preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor= preferences.edit();
        initView();
        initDatas();
        onListener();
    }
    private void initDatas() {
        //  启动接口回调 解析数据
        CityPresenter cityPresenter = new CityPresenter(this);
        cityPresenter.doSomeThingThree();
        Intent intent = getIntent();
        currentcityname = intent.getStringExtra("cityname");
        // 给当前城市赋值
        mCurrentCity.setText(currentcityname);

    }
    private void initView() {
        mScrollView = (ScrollView) findViewById(R.id.choosecity_scrollview);
        mCurrentCity = (TextView) findViewById(R.id.choosecity_currentcityname_txt);
        mScroll_txt = (TextView) findViewById(R.id.choosecity_scroll_txt);
        mLastCity_one_txt = (TextView) findViewById(R.id.choosecity_lastcity_one_txt);
        mLastCity_two_txt = (TextView) findViewById(R.id.choosecity_lastcity_two_txt);
        mLastCity_three_txt = (TextView) findViewById(R.id.choosecity_lastcity_three_txt);
        String lastcity_one = preferences.getString("choose_city",null);
        String lastcity_two = preferences.getString("lastcity_two", null);
        String lastcity_three = preferences.getString("lastcity_three", null);
        mLastCity_one_txt.setText(lastcity_one);
        mLastCity_two_txt.setText(lastcity_two);
        mLastCity_three_txt.setText(lastcity_three);
        mGridView = (CustomGridView) findViewById(R.id.choosecity_gridview);
        mListView = (CustomListView) findViewById(R.id.choosecity_listview);
        myGridViewAdapter = new MyGridViewAdapter(this);
        mGridView.setAdapter(myGridViewAdapter);
        myListViewAdapter = new MyListViewAdapter(this);
        mListView.setAdapter(myListViewAdapter);
    }
    private void onListener() {
         mScrollView.setOnTouchListener(new TouchListenerImpl());
         mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent intent = new Intent(ChooseCityActivity.this,ChooseCityDetialActivity.class);
                 CityBeen.ResultBean.CityListBean cityListBean = hotcity_list.get(position);
                 int city_id = cityListBean.getCity_id();
                 String city_name = cityListBean.getCity_name();
                 editor.putString("choose_city",city_name);
                 editor.apply();
                 editor.putInt("choose_city_id",city_id);
                 editor.apply();
                 intent.putExtra("city_id",city_id);
                 intent.putExtra("city_name",city_name);
//                 LogPrint.doLogi(ChooseCityActivity.class,city_id);
                 startActivity(intent);
             }
         });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ChooseCityActivity.this,ChooseCityDetialActivity.class);
                String s = tatalList.get(position);
                int city_id = 0;
                for (int i = 1; i < dataList.size(); i++) {
                    CityBeen.ResultBean resultBean1 = dataList.get(i);
                    List<CityBeen.ResultBean.CityListBean> city_list = resultBean1.getCity_list();
                    for (int j = 0; j < city_list.size(); j++) {
                        CityBeen.ResultBean.CityListBean cityListBean = city_list.get(j);
                        String city_name = cityListBean.getCity_name();
                        if (city_name.equals(s)) {
                             city_id = cityListBean.getCity_id();
                            String city_name1 = cityListBean.getCity_name();
                            intent.putExtra("city_name",city_name1);
                            editor.putString("choose_city",city_name1);
                            editor.apply();
                        }
                    }
                }
//                LogPrint.doLogi(ChooseCityActivity.class,city_id);
                editor.putInt("choose_city_id",city_id);
                editor.apply();
                intent.putExtra("city_id",city_id);
                startActivity(intent);
            }

        });
    }
    private class  TouchListenerImpl implements View.OnTouchListener{
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN:

                break;
                case  MotionEvent.ACTION_MOVE:
                    // 当前不可见的高度
                    int scrollY = v.getScrollY();
                    //  当前可见范围的高度
                    int height = v.getHeight();
                    //  scrollview 的总高度
                    int measuredHeight = mScrollView.getChildAt(0).getMeasuredHeight();
//                    mScrollView.get
                    break;

            }
            return false;
        }
    }
    @Override
    public void getViewResult(List<CityBeen.ResultBean> list) {
//        LogPrint.doLogi(ChooseCityActivity.class,list.size());
        this.dataList.addAll(list);
        CityBeen.ResultBean resultBean = dataList.get(0);
        // 获得热门城市的list集合
        hotcity_list = resultBean.getCity_list();
        myGridViewAdapter.notifyDataSetChanged();
        // 获得所有城市的的 类名 和城市名
        for (int i = 1; i < dataList.size(); i++) {
            CityBeen.ResultBean resultBean1 = dataList.get(i);
            String begin_key = resultBean1.getBegin_key();
            tatalList.add(begin_key);
            List<CityBeen.ResultBean.CityListBean> city_list = resultBean1.getCity_list();
            for (int j = 0; j < city_list.size(); j++) {
                CityBeen.ResultBean.CityListBean cityListBean = city_list.get(j);
                String city_name = cityListBean.getCity_name();
                tatalList.add(city_name);
            }
        }
        myListViewAdapter.notifyDataSetChanged();
    }


    class MyGridViewAdapter extends BaseAdapter{
        private LayoutInflater myInFlater;
        public MyGridViewAdapter(Context context) {
            this.myInFlater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return hotcity_list == null? 0 :hotcity_list.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = null;
            if (convertView == null) {
                convertView = myInFlater.inflate(R.layout.hotcity_gridview_item,parent,false);
                textView = (TextView) convertView.findViewById(R.id.choosecity_gridview_item_txt);
                convertView.setTag(textView);
            }else {
                textView = (TextView) convertView.getTag();
            }
            CityBeen.ResultBean.CityListBean cityListBean = hotcity_list.get(position);
            String city_name = cityListBean.getCity_name();
            textView.setText(city_name);
            return convertView;
        }
    }
    class  MyListViewAdapter extends  BaseAdapter{
        private LayoutInflater myInflater;
        public MyListViewAdapter(Context context) {

            this.myInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return tatalList == null ? 0 :tatalList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = null;
            if (convertView == null) {
                convertView = myInflater.inflate(R.layout.hotcity_listview_body_item,parent,false);
                textView = (TextView) convertView.findViewById(R.id.choosecity_listview_body_item_txt);
                convertView.setTag(textView);
            }else {
                textView = (TextView) convertView.getTag();
            }
            int length = tatalList.get(position).length();
            if (length == 1) {
                textView.setText(tatalList.get(position));
                textView.setTextColor(Color.GRAY);
            }else {
                textView.setText(tatalList.get(position));
            }
            return convertView;
        }
    }
}
