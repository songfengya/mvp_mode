package com.example.layzzweekend.model;

import com.example.layzzweekend.been.CityBeen;
import com.example.layzzweekend.pathname.UrlPath;
import com.example.layzzweekend.tools.AsyncTaskTool;
import com.example.layzzweekend.tools.LogPrint;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public class CityBeen_Model implements IModel_CityBeen{
    @Override
    public void parserJson(final IModel_Presenter_CityBeen iModel_presenter_cityBeen) {
        AsyncTaskTool.load(UrlPath.CITY_DATA_PATH).execute(new AsyncTaskTool.IMyCallback() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                CityBeen cityBeen = gson.fromJson(result, CityBeen.class);
                List<CityBeen.ResultBean> beenList = cityBeen.getResult();
                LogPrint.doLogi(CityBeen_Model.class,beenList.size());
                //  结果为 23  size()
                iModel_presenter_cityBeen.getResultThree(beenList);
            }
        });
    }
}
