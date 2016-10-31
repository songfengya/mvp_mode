package com.example.day36_mvc_demo.model;

import android.util.Log;

import com.example.day36_mvc_demo.Tools.LogUtils;
import com.example.day36_mvc_demo.view.IDetailViewResult;
import com.example.day36_mvc_demo.view.IMainViewResult;
import com.example.day36_mvc_demo.been.MainBeen;
import com.example.day36_mvc_demo.model.http.URLPath;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2016/10/31.
 */
public class Data_Model {
 private static final String TAG = "androidxx";
 private IMainViewResult iMainViewResult;

 public Data_Model(IMainViewResult iMainViewResult) {
  this.iMainViewResult = iMainViewResult;
 }

 public void  parserJson(){
  Log.i(TAG, "parserJson: ");
  RequestParams requestParams = new RequestParams(URLPath.MAIN_LIST_URL);
  requestParams.addBodyParameter("pageno","1");
  x.http().post(requestParams, new Callback.CommonCallback<String>() {
   @Override
   public void onSuccess(String result) {
    Log.i(TAG, "onSuccess: "+result);
    Gson gson = new Gson();
    MainBeen mainBeen = gson.fromJson(result, MainBeen.class);
    iMainViewResult.getMainBeenReault(mainBeen);
   }

   @Override
   public void onError(Throwable ex, boolean isOnCallback) {
         ex.printStackTrace();
   }

   @Override
   public void onCancelled(CancelledException cex) {
           cex.printStackTrace();
   }

   @Override
   public void onFinished() {

   }
  });
 }
  private IDetailViewResult iDetailViewResult;

 public Data_Model(IDetailViewResult iDetailViewResult) {
  this.iDetailViewResult = iDetailViewResult;
 }

 public void detialJson(String id){
  RequestParams requestParams = new RequestParams(URLPath.DETAIL_URL);
  requestParams.addBodyParameter("id",id);

 x.http().post(requestParams, new Callback.CommonCallback<String>() {
  @Override
  public void onSuccess(String result) {
   iDetailViewResult.getDetailViewResult(result);
  }

  @Override
  public void onError(Throwable ex, boolean isOnCallback) {

  }

  @Override
  public void onCancelled(CancelledException cex) {

  }

  @Override
  public void onFinished() {

  }
 });

  }
}
