package com.example.layzzweekend.presenter;

import com.example.layzzweekend.been.CityBeen;
import com.example.layzzweekend.model.CityBeen_Model;
import com.example.layzzweekend.model.IModel_CityBeen;
import com.example.layzzweekend.model.IModel_Presenter_CityBeen;
import com.example.layzzweekend.view.ICityBeenResult;

import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */
public class CityPresenter implements IModel_Presenter_CityBeen {
    private IModel_CityBeen iModel_cityBeen = new CityBeen_Model();
    private ICityBeenResult iCityBeenResult;
    public  CityPresenter(ICityBeenResult iCitytBeenResult){
        this.iCityBeenResult = iCitytBeenResult;
    }
    public  void doSomeThingThree(){
        iModel_cityBeen.parserJson(this);
    }

    @Override
    public void getResultThree(List<CityBeen.ResultBean> list) {
        iCityBeenResult.getViewResult(list);
    }
}
