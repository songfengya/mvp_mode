package com.example.layzzweekend.model;

import com.example.layzzweekend.been.FirstFragment_Been;
import com.example.layzzweekend.been.FirstFragment_MainDetail_Been;
import com.example.layzzweekend.tools.AsyncTaskTool;
import com.example.layzzweekend.tools.LogPrint;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public class FirstFragment_Detail_Model implements  IModel_Detail{
    public void parserJson(final IModel_Presenter_Detail iModel_presenter_detail, String path){
       LogPrint.doLogi(FirstFragment_Detail_Model.class,path);
      AsyncTaskTool.load(path).execute(new AsyncTaskTool.IMyCallback() {
          @Override
          public void success(String result) {
              try {
                  JSONObject jsonObject = new JSONObject(result);
                  FirstFragment_MainDetail_Been been = new FirstFragment_MainDetail_Been();
//                  private List<String> descriptionList;
//                  private List<String> lrzm_tipsList;
//                  private List<String> booking_policyList;
//                  private List<String> ticket_ruleList;
//                  private List<String> ticket_usageList;
//                  private List<String> represent_dataList;
                  /// 结果的JSONObject
                  JSONObject resultjsonObject = jsonObject.getJSONObject("result");
                  //第一个集合数据
                  JSONArray descriptionArray = resultjsonObject.getJSONArray("description");
                  List<String> descriptionList = new ArrayList<String>();
                  for (int i = 0,len = descriptionArray.length(); i < len; i++) {
                      JSONObject description_item = descriptionArray.getJSONObject(i);
                      String type = description_item.getString("type");
                      String content = description_item.getString("content");
                      descriptionList.add(type);
                      descriptionList.add(content);
                  }
                  // 第二个集合数据
                  JSONArray lrzm_tipsArray = resultjsonObject.getJSONArray("lrzm_tips");
                  List<String> lrzm_tipsList = new ArrayList<String>();
                  for (int j = 0,len2 = lrzm_tipsArray.length(); j < len2; j++) {
                      JSONObject lrzm_item = lrzm_tipsArray.getJSONObject(j);
                      String content = lrzm_item.getString("content");
                      lrzm_tipsList.add(content);
                  }
                  // 第三个集合数据
                  JSONArray booking_policyArray = resultjsonObject.getJSONArray("booking_policy");
                  List<String> booking_policyList = new ArrayList<String>();
                  for (int z = 0,len3 = booking_policyArray.length(); z < len3; z++) {
                      JSONObject booking_policy_item = booking_policyArray.getJSONObject(z);
                      String content = booking_policy_item.getString("content");
                      booking_policyList.add(content);
                  }
                 // 第四个集合数据
                  JSONArray ticket_ruleArray = resultjsonObject.getJSONArray("ticket_rule");
                  List<String> ticket_ruleList = new ArrayList<String>();
                  for (int o = 0,len4 = ticket_ruleArray.length(); o < len4; o++) {
                      JSONObject ticket_rule_item = ticket_ruleArray.getJSONObject(o);
                      String content = ticket_rule_item.getString("content");
                      ticket_ruleList.add(content);
                  }
                  // 第五个集合数据
                  JSONArray ticket_usageArray = resultjsonObject.getJSONArray("ticket_usage");
                  List<String> ticket_usageList = new ArrayList<String>();
                  for (int p = 0,len5 = ticket_usageArray.length(); p < len5; p++) {
                      JSONObject ticket_usage_item = ticket_usageArray.getJSONObject(p);
                      String content = ticket_usage_item.getString("content");
                      ticket_usageList.add(content);
                  }
                // 第六个集合数据
                  JSONObject json = resultjsonObject.getJSONObject("sku_representation");
                  List<String> represent_dataList = new ArrayList<String>();
                  JSONArray represent_dataArray = json.getJSONArray("represent_data");
                  JSONObject represent_data_item = represent_dataArray.getJSONObject(0);
                  String title = represent_data_item.getString("title");
                  String represent_type = json.getString("represent_type");
                  represent_dataList.add(title);
                  represent_dataList.add(represent_type);
                  // 给been对象赋值
                  been.setDescriptionList(descriptionList);
                  been.setLrzm_tipsList(lrzm_tipsList);
                  been.setBooking_policyList(booking_policyList);
                  been.setTicket_ruleList(ticket_ruleList);
                  been.setTicket_usageList(ticket_usageList);
                  been.setRepresent_dataList(represent_dataList);
                  iModel_presenter_detail.getResult(been);

              } catch (JSONException e) {
                  e.printStackTrace();
              }

          }
      });
    }
}
