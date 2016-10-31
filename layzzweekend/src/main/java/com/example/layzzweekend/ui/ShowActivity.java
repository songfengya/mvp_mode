package com.example.layzzweekend.ui;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.model.LatLng;
import com.example.layzzweekend.R;
import com.example.layzzweekend.tools.LogPrint;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity implements BDLocationListener {

    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private List<Fragment> fragmentList = new ArrayList<>();
    private MyFragmentAdapter myFragmentAdapter;
    private LocationClient locationClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stratBaiduMap();
        setContentView(R.layout.activity_show);
        initView();
        initDatas();

    }

    private void stratBaiduMap() {
        // 启动定位服务
        locationClient = new LocationClient(getApplicationContext());
        initLocation();
        locationClient.registerLocationListener(this);
        locationClient.start();
    }


    private void initDatas() {
        fragmentList.add(FirstFragment.newInstance());
        fragmentList.add(SecondFragment.newInstance());
        fragmentList.add(ThirdFragment.newInstance());
        fragmentList.add(FourthFragment.newInstance());
        myFragmentAdapter.notifyDataSetChanged();
    }

    /**
     *  初始化 Location参数
     */
    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span=0;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        locationClient.setLocOption(option);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.show_viewpager);
        mRadioGroup = (RadioGroup) findViewById(R.id.show_radiogroup);
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//        int id = preferences.getInt("radiobutton", R.id.show_one_btn);
        // 这里有个bug
        mRadioGroup.check(R.id.show_one_btn);
        onListener();
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentAdapter);
    }
    private void onListener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                       switch (checkedId){
                           case R.id.show_one_btn:
                               mViewPager.setCurrentItem(0);
                           break;
                           case R.id.show_two_btn:
                               mViewPager.setCurrentItem(1);
                               break;
                           case R.id.show_three_btn:
                               mViewPager.setCurrentItem(2);
                               break;
                           case R.id.show_four_btn:
                               mViewPager.setCurrentItem(3);
                               break;
                       }
            }
         }
        );

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                   mRadioGroup.check(R.id.show_one_btn);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.show_two_btn);
                        break;
                    case 2:
                        mRadioGroup.check(R.id.show_three_btn);
                        break;
                    case 3:
                        mRadioGroup.check(R.id.show_four_btn);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
                double latitude = bdLocation.getLatitude();
                double longitude = bdLocation.getLongitude();
        Address address = bdLocation.getAddress();
        String city = address.city;
        String cityCode = address.cityCode;
        String province = address.province;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = preferences.edit();
        //在 sharePreferences 中存有且只有一个：省 城市 城市代码 城市当前纬度 城市当前经度 的值
        edit.putString("cityCode",cityCode);
        edit.putString("province",province);
        edit.putString("city",city);
        edit.putFloat(city+"latitude", (float) latitude);
        edit.putFloat(city+"longitude", (float) longitude);
        edit.apply();
    }

    class  MyFragmentAdapter extends FragmentPagerAdapter{

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList == null ? 0 : fragmentList.size();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
