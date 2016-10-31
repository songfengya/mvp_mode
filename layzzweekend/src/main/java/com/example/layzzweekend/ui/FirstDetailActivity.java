package com.example.layzzweekend.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.example.layzzweekend.R;
import com.example.layzzweekend.been.FirstFragment_Been;
import com.example.layzzweekend.been.FirstFragment_MainDetail_Been;
import com.example.layzzweekend.pathname.UrlPath;
import com.example.layzzweekend.presenter.UserPresenter;
import com.example.layzzweekend.tools.ImageLoader;
import com.example.layzzweekend.tools.LogPrint;
import com.example.layzzweekend.view.CustomListView;
import com.example.layzzweekend.view.IObjectBeenResult;

import java.util.List;

/**
 *
 */
public class FirstDetailActivity extends AppCompatActivity implements IObjectBeenResult {
    private Toolbar mToolbar;
    private ScrollView mScrollView;
    private TextView mTitle_txt;
    private ViewPager mViewPager;
    private TextView mPrice_txt;
    private TextView mTime_txt;
    private TextView mAddress_txt;
    private CustomListView mCustomListView;
    private FirstFragment_Been been;
    private FirstFragment_MainDetail_Been detail_been;
    private List<String> front_cover_image_list;
    private int imageCount;
    private Handler handler = new Handler(){
       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
           int index = mViewPager.getCurrentItem();
           mViewPager.setCurrentItem(index+1);
           sendEmptyMessageDelayed(1,3000);
       }
   };
    private MyViewPagerAdapter myViewPagerAdapter;
    private TextView mType_txt;
    private List<String> descriptionList;
    private MyCustomListView myCustomListViewAdapter;
    private RelativeLayout mRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_detail);
        initJson();
        mToolbar = (Toolbar) findViewById(R.id.first_detail_toolbar);
        setSupportActionBar(mToolbar);
        initView();
        initDatas();
        setTextView();

    }

    private void initJson() {
        Intent intent = getIntent();
        been = (FirstFragment_Been) intent.getSerializableExtra("been");
        String leo_id = been.getLeo_id();
        // 配置详情界面的url地址
        String realPath = UrlPath.FIRST_FRAG_DETAIL_HEAD_PATH+leo_id;
        LogPrint.doLogi(FirstDetailActivity.class,realPath);
        UserPresenter userPresenter = new UserPresenter(this);
        userPresenter.doSomeThingTwo(realPath);
    }

    private void initDatas() {
        front_cover_image_list = been.getFront_cover_image_list();
        imageCount = front_cover_image_list.size();
        myViewPagerAdapter.notifyDataSetChanged();
    }

    private void initView() {
        mRoot = (RelativeLayout) findViewById(R.id.first_detail_root_layout);
        mScrollView = (ScrollView) findViewById(R.id.first_detail_scrollview);
        mViewPager = (ViewPager) findViewById(R.id.first_detail_scrollview_viewpager);
        mTitle_txt = (TextView) findViewById(R.id.first_detail_scrollview_title_txt);
        mType_txt = (TextView) findViewById(R.id.first_detail_scrollview_type_txt);
        mPrice_txt = (TextView) findViewById(R.id.first_detail_scrollview_price_txt);
        mTime_txt = (TextView) findViewById(R.id.first_detail_scrollview_time_txt);
        mAddress_txt = (TextView) findViewById(R.id.first_detail_scrollview_adress_txt);
        mCustomListView = (CustomListView) findViewById(R.id.first_detail_scrollview_customlistview_one);
        // viewpager 做适配
        mViewPager.setCurrentItem(Integer.MAX_VALUE/2);
        myViewPagerAdapter = new MyViewPagerAdapter();
        mViewPager.setAdapter(myViewPagerAdapter);
        handler.sendEmptyMessage(1);

    }

    // 给TextView赋值
    private void setTextView() {
        mTitle_txt.setText(been.getTitle());
        mType_txt.setText("类型："+been.getCategory());
        mPrice_txt.setText(been.getPrice_info());
        mTime_txt.setText(been.getTime_desc());
        mAddress_txt.setText(been.getAddress());
    }

    /**
     * 为toolbar的四张图片做点击监听分发
     * @param view
     */
    public void click(View view){
        int id = view.getId();
        switch (id){
            case R.id.first_detail_toolbar_img_one:
                Intent intent  = new Intent(this,ShowActivity.class);

                startActivity(intent);
                // -----
            break;
            case R.id.first_detail_toolbar_img_two:
                final PopupWindow popupWindow = new PopupWindow(this);
                View inflate = LayoutInflater.from(this).inflate(R.layout.popupwindow_item, null);

                popupWindow.setContentView(inflate);
                popupWindow.setFocusable(true);
                popupWindow.setOutsideTouchable(true);

                popupWindow.showAtLocation(mRoot, Gravity.LEFT,0,0);
                inflate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                break;
            case R.id.first_detail_toolbar_img_three:
                Intent intent2 = new Intent(this,UserLoginActivity.class);
                startActivity(intent2);
                break;
            case R.id.first_detail_toolbar_img_four:
                 Intent intent3 = new Intent(this,ConsultActivity.class);
                startActivity(intent3);
                break;

        }

    }

    /**
     * 接口回调得到详情界面的数据
     * @param object
     */

    @Override
    public void getViewResult(FirstFragment_MainDetail_Been object) {

        LogPrint.doLogi(FirstDetailActivity.class,object);
        detail_been = new FirstFragment_MainDetail_Been();
        detail_been = object;
        initSecondPartView();
        myCustomListViewAdapter.notifyDataSetChanged();
    }
    private void initSecondPartView() {
        // 给mCustomListView做适配
        descriptionList = detail_been.getDescriptionList();
        myCustomListViewAdapter = new MyCustomListView(this);
        mCustomListView.setAdapter(myCustomListViewAdapter);
        // 给下面的textview 赋值
        // 懒人提示list
         List<String>  lrzm_tipsList = detail_been.getLrzm_tipsList();
        TextView lrzm_txt = (TextView) findViewById(R.id.first_detail_scrollview_onelayout_content_txt);
       StringBuilder sb = new StringBuilder();
        int len = lrzm_tipsList.size();
        if (len > 0) {
            for (int i = 0; i <len ; i++) {
                sb.append(String.valueOf(i+1)).append(".").append(lrzm_tipsList.get(i)).append("\n");
            }
            lrzm_txt.setText(sb.toString());
        }
        // 预定须知list
        List<String> booking_policyList = detail_been.getBooking_policyList();
        TextView booking_txt = (TextView) findViewById(R.id.first_detail_scrollview_twolayout_content_txt);
        StringBuilder sb2 = new StringBuilder();
        int len2 = booking_policyList.size();
        if (len2 >0) {
            for (int j = 0; j <len2; j++) {
                sb2.append(String.valueOf(j+1)).append(".").append(booking_policyList.get(j)).append("\n");
            }
            booking_txt.setText(sb2.toString());
        }
        //如何使用list
        List<String> ticket_ruleList = detail_been.getTicket_ruleList();
        TextView rule_txt = (TextView) findViewById(R.id.first_detail_scrollview_threelayout_content_txt);
        StringBuilder sb3 = new StringBuilder();
        int len3 = ticket_ruleList.size();
        if (len3 > 0) {
            for (int k = 0; k < len3; k++) {
                sb3.append(String.valueOf(k+1)).append(".").append(ticket_ruleList.get(k)).append("\n");
            }
            rule_txt.setText(sb3.toString());
        }
        // 退改规则list
        List<String> ticket_usageList = detail_been.getTicket_usageList();
        TextView usage_txt = (TextView) findViewById(R.id.first_detail_scrollview_fourlayout_content_txt);
        StringBuilder sb4 = new StringBuilder();
        int len4 = ticket_usageList.size();
        if (len4 > 0) {
            for (int z = 0; z < len4; z++) {
                sb4.append(String.valueOf(z+1)).append(".").append(ticket_usageList.get(z)).append("\n");
            }
            usage_txt.setText(sb4.toString());
        }
        // 票务类型
        List<String> represent_dataList = detail_been.getRepresent_dataList();
        TextView represent_txt = (TextView) findViewById(R.id.first_detail_scrollview_fivelayout_content_txt);
        if (represent_dataList.size() > 0) {
            represent_txt.setText(represent_dataList.get(0));
        }

    }
    class MyViewPagerAdapter extends PagerAdapter{

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
            ImageView view = (ImageView) LayoutInflater.from(FirstDetailActivity.this).inflate(R.layout.imageview_item, null);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ImageLoader.load(FirstDetailActivity.this,front_cover_image_list.get(position%imageCount),view,200,150);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView((View) object);
        }
    }

    /**
     * CustomListView 的适配器
     */
    class MyCustomListView extends BaseAdapter{
        private LayoutInflater myInflater;
        private  Context context;
        private int type;
        public MyCustomListView(Context context) {
            this.context = context;
            this.myInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return descriptionList == null ? 0 : descriptionList.size()/2;
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
        public int getItemViewType(int position) {
            String s = descriptionList.get(position*2);

            if (s.equals("text")) {
                //0 代表文本
                type = 0;
            }else {
                // 1 代表图片
                type = 1;
            }
            return type;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView =null;
            ImageView imageView = null;
            if (convertView == null) {
                switch (type){
                    case 0:
                        textView = new TextView(context);
                        convertView = textView;
                        break;
                    case 1:
                        View view =  myInflater.inflate(R.layout.imageview_detail_item,null);
                        imageView = (ImageView) view.findViewById(R.id.image_detail_item_img);
                        convertView = imageView;
                        break;
                }
            }else {
                switch (type){
                    case 0:
                        textView = (TextView) convertView;
                    break;
                    case 1:
                        imageView = (ImageView) convertView;
                        break;
                }
            }

            switch (type) {
                case 0:
                    textView.setText(descriptionList.get(position*2+1));
                    break;
                case 1:
                    ImageLoader.load(context,descriptionList.get(position*2+1),imageView,200,150);
                    break;
            }

            return convertView;
        }
    }

}
