package com.example.layzzweekend.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.layzzweekend.R;

public class FourthFragment extends Fragment {


    private Context context;
    private LinearLayout mLine_layout;

    public static FourthFragment newInstance() {
        FourthFragment fragment = new FourthFragment();
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
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mLine_layout = (LinearLayout) view.findViewById(R.id.fourfragment_line_layout);
        int childCount = mLine_layout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = mLine_layout.getChildAt(i);
            childAt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();
                    // 分别为三个textview设施监听 click后跳转
                    switch (id) {
                        case R.id.fourfragment_order_txt:
                        break;
                        case R.id.fourfragment_interst_txt:
                            break;
                        case R.id.fourfragment_setting_txt:
                            break;
                    }

                }
            });
        }
    }



}
