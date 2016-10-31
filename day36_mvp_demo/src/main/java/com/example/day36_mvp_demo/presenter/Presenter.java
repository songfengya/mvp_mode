package com.example.day36_mvp_demo.presenter;

import com.example.day36_mvp_demo.been.GiftBeen;
import com.example.day36_mvp_demo.view.IMainView;

import model.IModel_Presenter;
import model.Main_Model;

/**
 * Created by Administrator on 2016/10/31.
 */
public class Presenter implements IModel_Presenter{
    private IMainView iMainView;
    public Presenter(IMainView iMainBeenResult) {
        this.iMainView = iMainBeenResult;
    }

    private  Main_Model main_model ;
    public void doSomeThing(int pageno){
        main_model = new Main_Model(this);
        main_model.parserJson(pageno);
    }
    @Override
    public void getModelResult(GiftBeen giftBeen) {
        iMainView.getMainBeenResult(giftBeen);
    }
}
