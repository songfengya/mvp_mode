package com.example.day37_bufferknife_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * Created by Administrator on 2016/11/1.
 */
public class MainFragment extends Fragment {
    @BindView(R.id.main_first_fragment_txt) TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.main_first_fragment, container, false);
        ButterKnife.bind(this,inflate);
        textView.setText("hello,is me");
        return inflate;
    }
}
