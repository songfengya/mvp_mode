package com.example.layzzweekend.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.example.layzzweekend.R;
import com.example.layzzweekend.been.FirstFragment_Been;
import com.example.layzzweekend.presenter.UserPresenter;
import com.example.layzzweekend.tools.LogPrint;
import com.example.layzzweekend.view.IViewResult;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment implements IViewResult,View.OnClickListener{


    private Context context;
    private EditText mEditText;
    private TextView mTextView;
    private List<FirstFragment_Been> beenList  = new ArrayList<>();
    private GridLayout mGridLayout;
    private TextView childTextView;
    private String cityName;
    private   SharedPreferences preferences;
    public static SecondFragment newInstance() {
        SecondFragment fragment = new SecondFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         preferences = PreferenceManager.getDefaultSharedPreferences(context);
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        initView(view);
        initDatas();
        onListener();
        return view;
    }

    /**
     *  启动FirstFragment_Model开启方法访问网络解析json数据
     */
    private void initDatas() {
        UserPresenter userPresenter = new UserPresenter(this);
        // 默认城市id为武汉 city_id = 192
        int choose_city_id = preferences.getInt("choose_city_id", 192);
        String path = "http://api.lanrenzhoumo.com/wh/common/leos?v=2&session_id=000040a3fb7d64ce1737c6c7bb3c7e4e157c91&lon=114.30963859310197&page=1&category=all&lat=30.575388756810078&city_id="+choose_city_id;
        userPresenter.doSomeThing(path);
    }


    private void initView(View view) {
        mEditText = (EditText) view.findViewById(R.id.secondfragment_toolbar_surch_edt);
        mTextView = (TextView)view.findViewById(R.id.secondfragment_toolbar_address_txt);
        mGridLayout = (GridLayout)view.findViewById(R.id.seconfragment_gridlayout);
        // 设置当前城市名称
        cityName = preferences.getString("city", "未知的");
        String choose_city = preferences.getString("choose_city", cityName);
        mTextView.setText(choose_city);
    }

    /**
     * 城市下拉监听 搜索EditText 控件的监听
     */
    private void onListener() {
        //  给城市添加 点击监听，
        //  城市点击事件失效 不知道什么原因
//        mTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//             Intent intent = new Intent(context,ChooseCityActivity.class);
//                intent.putExtra("cityname",cityName);
//                startActivity(intent);
//            }
//        });
        mTextView.setOnClickListener(this);
        // 搜索EditText 控件的监听
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        int childCount = mGridLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            childTextView = (TextView)mGridLayout.getChildAt(i);
            childTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();
                    switch (id) {
                        case R.id.seconfragment_gridlayout_txt_one:
                            Intent intent1 = new Intent(context,SecondDetailActivity.class);
                            intent1.putExtra("cn_name","全部类目");
                            startActivity(intent1);
                            break;
                        case R.id.seconfragment_gridlayout_txt_two:
                            Intent intent2 = new Intent(context,SecondDetailActivity.class);
                            intent2.putExtra("cn_name","沙龙学堂");
                            startActivity(intent2);
                            break;
                        case R.id.seconfragment_gridlayout_txt_three:
                            Intent intent3 = new Intent(context,SecondDetailActivity.class);
                            intent3.putExtra("cn_name","DIY手作");
                            startActivity(intent3);
                            break;
                        case R.id.seconfragment_gridlayout_txt_four:
                            Intent intent4 = new Intent(context,SecondDetailActivity.class);
                            intent4.putExtra("cn_name","派对聚会");
                            startActivity(intent4);
                            break;
                        case R.id.seconfragment_gridlayout_txt_five:
                            Intent intent5 = new Intent(context,SecondDetailActivity.class);
                            intent5.putExtra("cn_name","暂不开放");
                            startActivity(intent5);
                            break;
                        case R.id.seconfragment_gridlayout_txt_six:
                            Intent intent6 = new Intent(context,SecondDetailActivity.class);
                            intent6.putExtra("cn_name","运动健身");
                            startActivity(intent6);
                            break;
                        case R.id.seconfragment_gridlayout_txt_seven:
                            Intent intent7 = new Intent(context,SecondDetailActivity.class);
                            intent7.putExtra("cn_name","户外活动");
                            startActivity(intent7);
                            break;
                        case R.id.seconfragment_gridlayout_txt_eight:
                            Intent intent8 = new Intent(context,SecondDetailActivity.class);
                            intent8.putExtra("cn_name","茶会雅集");
                            startActivity(intent8);
                            break;
                        case R.id.seconfragment_gridlayout_txt_nine:
                            Intent intent9 = new Intent(context,SecondDetailActivity.class);
                            intent9.putExtra("cn_name","文艺生活");
                            startActivity(intent9);
                            break;
                    }
                }
            });
        }

    }



    @Override
    public void getViewResult(List<FirstFragment_Been> list) {
        beenList.addAll(list);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.secondfragment_toolbar_address_txt:
                Intent intent = new Intent(context,ChooseCityActivity.class);
                intent.putExtra("cityname",cityName);
                startActivity(intent);
            break;

        }
    }
}
