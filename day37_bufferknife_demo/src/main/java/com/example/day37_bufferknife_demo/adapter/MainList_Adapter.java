package com.example.day37_bufferknife_demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.day37_bufferknife_demo.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/1.
 */
public class MainList_Adapter extends BaseAdapter {
    private  Context context;
    private LayoutInflater mInflater;
    public MainList_Adapter(Context context) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 20;
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.main_list_item,parent,false);
            holder = new ViewHolder(convertView);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText("item"+position);
        return convertView;
    }
    class ViewHolder{
        @BindView(R.id.main_list_item_txt)
        public TextView textView;

        public ViewHolder(View view) {
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }
}
