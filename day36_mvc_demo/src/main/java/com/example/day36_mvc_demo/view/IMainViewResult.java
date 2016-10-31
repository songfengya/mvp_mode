package com.example.day36_mvc_demo.view;

import com.example.day36_mvc_demo.been.MainBeen;

/**
 * 通过此类完成接口回调 将Model层数据 传递给MainViewResult层
 * Created by Administrator on 2016/10/31.
 */
public interface IMainViewResult {
    void getMainBeenReault(MainBeen mainBeen);
}
