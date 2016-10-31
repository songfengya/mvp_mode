package com.example.layzzweekend.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.layzzweekend.R;
import com.example.layzzweekend.been.FirstFragment_Been;
import com.example.layzzweekend.presenter.UserPresenter;
import com.example.layzzweekend.service.IMapCallback;
import com.example.layzzweekend.service.MapService;
import com.example.layzzweekend.tools.ImageAsyncTaskLoadTools;
import com.example.layzzweekend.tools.ImageLoader;
import com.example.layzzweekend.tools.LogPrint;
import com.example.layzzweekend.view.IViewResult;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements IViewResult {

    private Context context;
    private PullToRefreshListView mPullListView;
    private List<FirstFragment_Been> beenList =new ArrayList<>();
    private MyListViewAdapter myListViewAdapter;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mPullListView.onRefreshComplete();
        }
    };
    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();

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

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        initView(view);
        initDatas();
        return view;
    }

    private void initDatas() {
        UserPresenter userPresenter = new UserPresenter(this);
        String path = "http://api.lanrenzhoumo.com/main/recommend/index?v=3&session_id=0000406fe0e9d86964136444743022589333f3&lon=114.42942&page=1&lat=30.418878";
         userPresenter.doSomeThing(path);
    }

    private void initView(View view) {
        mPullListView = (PullToRefreshListView) view.findViewById(R.id.firstfragment_pull_listview);
        mPullListView.setMode(PullToRefreshBase.Mode.BOTH);
        myListViewAdapter = new MyListViewAdapter(context);
        mPullListView.setAdapter(myListViewAdapter);
        mPullListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                       myListViewAdapter.notifyDataSetChanged();
                     handler.sendEmptyMessage(1);
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                myListViewAdapter.notifyDataSetChanged();
                handler.sendEmptyMessage(2);
            }
        });
        mPullListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context,FirstDetailActivity.class);
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

    class MyListViewAdapter extends BaseAdapter{

        private LayoutInflater myInflater;

        public MyListViewAdapter(Context context) {
            this.myInflater = LayoutInflater.from(context);
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
        class ViewHolder{
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
