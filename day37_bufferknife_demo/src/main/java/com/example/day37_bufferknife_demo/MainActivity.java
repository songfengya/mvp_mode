 package com.example.day37_bufferknife_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.day37_bufferknife_demo.adapter.MainList_Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;

 public class MainActivity extends AppCompatActivity {
     @BindView(R.id.main_listview)
     ListView mListView;
     private MainList_Adapter mainList_adapter;
     private View inflate;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
         mainList_adapter = new MainList_Adapter(this);
         mListView.setAdapter(mainList_adapter);
         // 给ListView 添加头部布局
         inflate = LayoutInflater.from(this).inflate(R.layout.main_head_item,null);
         ViewHolder viewHolder = new ViewHolder(inflate);
         viewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
         mListView.addHeaderView(inflate);
     }
     class  ViewHolder {
         @BindView(R.id.main_head_img)
         ImageView imageView;
         public ViewHolder(View view) {
             ButterKnife.bind(this,view);
         }
     }

}
