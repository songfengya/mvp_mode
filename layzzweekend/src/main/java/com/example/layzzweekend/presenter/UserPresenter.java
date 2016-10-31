package com.example.layzzweekend.presenter;

import com.example.layzzweekend.been.CityBeen;
import com.example.layzzweekend.been.FirstFragment_Been;
import com.example.layzzweekend.been.FirstFragment_MainDetail_Been;
import com.example.layzzweekend.model.CityBeen_Model;
import com.example.layzzweekend.model.FirstFragment_Detail_Model;
import com.example.layzzweekend.model.FirstFragment_Model;
import com.example.layzzweekend.model.IModel;
import com.example.layzzweekend.model.IModel_CityBeen;
import com.example.layzzweekend.model.IModel_Detail;
import com.example.layzzweekend.model.IModel_Presenter;
import com.example.layzzweekend.model.IModel_Presenter_CityBeen;
import com.example.layzzweekend.model.IModel_Presenter_Detail;
import com.example.layzzweekend.tools.LogPrint;
import com.example.layzzweekend.view.ICityBeenResult;
import com.example.layzzweekend.view.IObjectBeenResult;
import com.example.layzzweekend.view.IViewResult;

import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */
public class UserPresenter implements IModel_Presenter,IModel_Presenter_Detail{
    private IViewResult iViewResult;
     private IModel iModel = new FirstFragment_Model();

    public UserPresenter(IViewResult iViewResult) {
        this.iViewResult = iViewResult;
    }

    public void doSomeThing(String path){
        iModel.parserJson(this,path);
    }

    @Override
    public void getResult(List<FirstFragment_Been> list) {
    iViewResult.getViewResult(list);
    }



    ///////////////// FirstFragment_MainDetail_Been 的MVP模式
    private IModel_Detail iModel_detail = new FirstFragment_Detail_Model();
    private IObjectBeenResult iObjectBeenResult;

    public UserPresenter(IObjectBeenResult iObjectBeenResult) {
        this.iObjectBeenResult = iObjectBeenResult;
    }

    public void doSomeThingTwo(String path){
        iModel_detail.parserJson(this,path);
    }
    @Override
    public void getResult(FirstFragment_MainDetail_Been object) {
        iObjectBeenResult.getViewResult(object);
    }



}
