package com.example.layzzweekend.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.layzzweekend.R;
import com.example.layzzweekend.been.FirstFragment_Been;
import com.example.layzzweekend.presenter.UserPresenter;
import com.example.layzzweekend.tools.ImageLoader;
import com.example.layzzweekend.view.IViewResult;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SecondDetailActivity extends AppCompatActivity implements IViewResult {

    private TextView mTextView;
    private PullToRefreshListView mPullListView;
    private String typeName;
    private List<FirstFragment_Been> beenList = new ArrayList<>();
    private  List<FirstFragment_Been> newList = new ArrayList<>();
    private MyPullListViewAdapter myPullListViewAdapter;
    public  static List<String> stringList = new ArrayList();
    private Handler handler = new Handler(){
      @Override
      public void handleMessage(Message msg) {
          super.handleMessage(msg);
          mPullListView.onRefreshComplete();
       }
  };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_detail);
        initDatas();
        initView();
    }

    private void initDatas() {
        Intent intent = getIntent();
        typeName = intent.getStringExtra("cn_name");
            stringList.add("全部类目");
            stringList.add("沙龙学堂");
            stringList.add("DIY手作");
            stringList.add("派对聚会");
            stringList.add("暂不开放");
            stringList.add("运动健身");
            stringList.add("户外活动");
            stringList.add("茶会雅集");
            stringList.add("文艺生活");
        /**
         *  启动FirstFragment_Model开启方法访问网络解析json数据
         */
        UserPresenter userPresenter = new UserPresenter(this);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        // 默认城市id为武汉 city_id = 192
        int choose_city_id = preferences.getInt("choose_city_id", 192);
        String path = "http://api.lanrenzhoumo.com/wh/common/leos?v=2&session_id=000040a3fb7d64ce1737c6c7bb3c7e4e157c91&lon=114.30963859310197&page=1&category=all&lat=30.575388756810078&city_id="+choose_city_id;
        userPresenter.doSomeThing(path);
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.seconddetail_title_txt);
        mTextView.setText(typeName);
        mPullListView = (PullToRefreshListView) findViewById(R.id.seconddetail_pull_listview);
        myPullListViewAdapter = new MyPullListViewAdapter(this);
        mPullListView.setAdapter(myPullListViewAdapter);
        mPullListView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
               myPullListViewAdapter.notifyDataSetChanged();
                handler.sendEmptyMessage(1);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                myPullListViewAdapter.notifyDataSetChanged();
                handler.sendEmptyMessage(2);
            }
        });
         mPullListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent intent  = new Intent(SecondDetailActivity.this,FirstDetailActivity.class);
                 if (newList.size() >= (position+1)) {
                     FirstFragment_Been been = newList.get(position);
                     intent.putExtra("been",been);
                     startActivity(intent);
                 }
             }
         });
    }

    /**
     * 对回退图标设置回退监听
     * @param view
     */
    public void click(View view ){
        Intent intent = new Intent(this,ShowActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt("radiobutton",R.id.show_two_btn);
        edit.apply();
        startActivity(intent);
    }

    @Override
    public void getViewResult(List<FirstFragment_Been> list) {
        beenList.addAll(list);
        // 对数据进行分发
        switch (typeName) {
            case "全部类目":
                newList.addAll(beenList);
                myPullListViewAdapter.notifyDataSetChanged();
            break;
            case "沙龙学堂":
                equalsType(1);
                break;
            case "DIY手作":
                equalsType(2);
                break;
            case "派对聚会":
                equalsType(3);
                break;
            case "暂不开放":
                equalsType(4);
                break;
            case "运动健身":
                equalsType(5);
                break;
            case "户外活动":
                equalsType(6);
                break;
            case "茶会雅集":
                equalsType(7);
                break;
            case "文艺生活":
                equalsType(8);
                break;
        }
    }

    private void equalsType(int count) {
        for (int i = 0; i < beenList.size(); i++) {
            FirstFragment_Been been = beenList.get(i);
            String category = been.getCategory();
            if (category.equals(stringList.get(count))){
                newList.add(been);
                myPullListViewAdapter.notifyDataSetChanged();
            }
        }
    }

    class MyPullListViewAdapter extends BaseAdapter{
        private LayoutInflater myInflater;
        private Context context;
        public MyPullListViewAdapter(Context context) {
            this.myInflater = LayoutInflater.from(context);
            this.context = context;
        }

        @Override
        public int getCount() {
//            if (newList.size() == 0){
//                Toast.makeText(context,"抱歉没有找到该类活动，去看看其他的吧",Toast.LENGTH_SHORT).show();
//            }
            return newList == null ? 0 :newList.size();
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
            FirstFragment_Been been = newList.get(position);
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
        class  ViewHolder{
            public ImageView imageView;
            public TextView text_one;
            public  TextView text_two;
            public TextView text_three;
            public  TextView text_four;
            public TextView text_five;
            public  ViewHolder(View view){
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
