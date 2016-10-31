package model;

import com.example.day36_mvp_demo.been.GiftBeen;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import model.http.URLPath;

/**
 * Created by Administrator on 2016/10/31.
 */
public class Main_Model  {
    private IModel_Presenter iModel_presenter;

    public Main_Model(IModel_Presenter iModel_presenter) {
        this.iModel_presenter = iModel_presenter;
    }

    public void parserJson(int pageno){
        RequestParams requestParams = new RequestParams(URLPath.MAIN_LIST_URL);
        requestParams.addBodyParameter("pageno",pageno+"");
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                GiftBeen giftBeen = gson.fromJson(result, GiftBeen.class);
                iModel_presenter.getModelResult(giftBeen);

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
