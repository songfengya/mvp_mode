package com.example.layzzweekend.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.layzzweekend.R;
import com.example.layzzweekend.been.FirstFragment_Been;
import com.example.layzzweekend.pathname.UrlPath;
import com.example.layzzweekend.presenter.UserPresenter;
import com.example.layzzweekend.tools.ImageLoader;
import com.example.layzzweekend.tools.LogPrint;
import com.example.layzzweekend.view.IViewResult;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ChooseCityDetialActivity extends AppCompatActivity implements IViewResult{

    private PullToRefreshListView mPullListView;
    private ImageView mImageView;
    private List<FirstFragment_Been> beenList = new ArrayList<>();
    private MyListViewAdapter myListViewAdapter;
    private TextView mChooseCity_txt;
    private String city_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city_detial);
        initDatas();
        initView();
    }
    private void initDatas() {
        Intent intent = getIntent();
        int city_id = intent.getIntExtra("city_id", 0);
        city_name = intent.getStringExtra("city_name");
        // 打印 闯过来的 city_id的值
//        LogPrint.doLogi(ChooseCityDetialActivity.class,city_id);
        String realpath = UrlPath.CHOOSE_CITY_DETAIL_PATH+city_id;
        UserPresenter userPresenter = new UserPresenter(this);
        userPresenter.doSomeThing(realpath);
    }

    private void initView() {
        mChooseCity_txt = (TextView) findViewById(R.id.choosecity_detial_cityname_txt);
        mChooseCity_txt.setText(city_name);
        //  后退图片
        mImageView = (ImageView) findViewById(R.id.choosecity_detial_back_img);
        mPullListView = (PullToRefreshListView) findViewById(R.id.choosecity_detial_pull_listview);
        myListViewAdapter = new MyListViewAdapter(this);
        mPullListView.setAdapter(myListViewAdapter);
        mPullListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ChooseCityDetialActivity.this,FirstDetailActivity.class);
                FirstFragment_Been been = beenList.get(position);
                intent.putExtra("been",been);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getViewResult(List<FirstFragment_Been> list) {
        beenList.addAll(list);
        myListViewAdapter.notifyDataSetChanged();

    }

    /**
     * listview的item布局 复用fragment_first_listview_item.xml的布局
     */
    class MyListViewAdapter extends BaseAdapter {
        private LayoutInflater myInflater;
        private  Context context;
        public MyListViewAdapter(Context context) {
            this.myInflater = LayoutInflater.from(context);
            this.context = context;
        }
        @Override
        public int getCount() {
            return beenList == null ? 0 : beenList.size();
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
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = myInflater.inflate(R.layout.fragment_first_listview_item,parent,false);
                holder = new ViewHolder(convertView);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            FirstFragment_Been been = beenList.get(position);
            List<String> front_cover_image_list = been.getFront_cover_image_list();
            ImageLoader.load(context,front_cover_image_list.get(0),holder.imageView,300,200);
            String distance = been.getDistance();
            double distance_f= Double.parseDouble(distance)/ 1000;
            BigDecimal bigDecimal = new BigDecimal(distance_f);
            double d2= bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            String distance_km = String.valueOf(d2);
            holder.text_one.setText(been.getTitle());
            holder.text_two.setText(been.getPoi_name()+"-"+distance_km+"km-"+been.getCategory());
            holder.text_three.setText(been.getTime_info());
            holder.text_four.setText(been.getCollected_num()+"人收藏");
            holder.text_five.setText(been.getPrice_info()+"元");
            return convertView;
        }

        class ViewHolder {
            public ImageView imageView;
            public TextView text_one;
            public TextView text_two;
            public TextView text_three;
            public TextView text_four;
            public TextView text_five;

            public ViewHolder(View view) {
                imageView = (ImageView) view.findViewById(R.id.firstfragment_listview_item_img);
                text_one = (TextView) view.findViewById(R.id.firstfragment_listview_item_txt_one);
                text_two = (TextView) view.findViewById(R.id.firstfragment_listview_item_txt_two);
                text_three = (TextView) view.findViewById(R.id.firstfragment_listview_item_txt_three);
                text_four = (TextView) view.findViewById(R.id.firstfragment_listview_item_txt_four);
                text_five = (TextView) view.findViewById(R.id.firstfragment_listview_item_txt_five);
                view.setTag(this);
            }
        }
    }
}
