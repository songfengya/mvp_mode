package com.example.layzzweekend.model;

import android.os.Handler;
import android.os.Message;

import com.example.layzzweekend.been.FirstFragment_Been;
import com.example.layzzweekend.pathname.UrlPath;
import com.example.layzzweekend.tools.AsyncTaskTool;
import com.example.layzzweekend.ui.FirstFragment;
import com.example.layzzweekend.ui.ShowActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public class FirstFragment_Model implements  IModel{
    private List<FirstFragment_Been> list = new ArrayList<>();
    public void parserJson(final IModel_Presenter iModel_presenter,String path){
        AsyncTaskTool.load(path).execute(new AsyncTaskTool.IMyCallback() {
            @Override
            public void success(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    for (int i = 0,len = jsonArray.length(); i < len; i++) {
                        FirstFragment_Been been = new FirstFragment_Been();
                        JSONObject item = jsonArray.getJSONObject(i);
                        String leo_id = item.getString("leo_id");
                        JSONArray arr_two = item.getJSONArray("front_cover_image_list");
                        List<String> imgList = new ArrayList<String>();
                        for (int j = 0,len_two= arr_two.length(); j < len_two; j++) {
                            String string = (String) arr_two.get(j);
                            imgList.add(string);
                        }
                        String title = item.getString("title");
                        String address = item.getString("address");
                        String poi_name = item.getString("poi_name");
                        String distance = item.getString("distance");
                        String category = item.getString("category");
                        String time_info = item.getString("time_info");
                        String time_desc = item.getString("time_desc");
                        String collected_num = item.getString("collected_num");
                        String price_info = item.getString("price_info");
                        been.setLeo_id(leo_id);
                        been.setFront_cover_image_list(imgList);
                        been.setTitle(title);
                        been.setAddress(address);
                        been.setPoi_name(poi_name);
                        been.setDistance(distance);
                        been.setCategory(category);
                        been.setTime_info(time_info);
                        been.setTime_desc(time_desc);
                        been.setCollected_num(collected_num);
                        been.setPrice_info(price_info);
                        list.add(been);
                    }

                    iModel_presenter.getResult(list);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
