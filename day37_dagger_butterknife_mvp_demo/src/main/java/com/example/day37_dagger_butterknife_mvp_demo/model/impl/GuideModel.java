package com.example.day37_dagger_butterknife_mvp_demo.model.impl;

import com.example.day37_dagger_butterknife_mvp_demo.common.URLPath;
import com.example.day37_dagger_butterknife_mvp_demo.model.IGuide_Model;
import com.example.day37_dagger_butterknife_mvp_demo.model.been.SelectedBeen;
import com.example.day37_dagger_butterknife_mvp_demo.presenter.IGuidePresenter;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2016/11/1.
 */
public class GuideModel implements IGuide_Model {
    @Override
    public void parserSelectedList(int pageno, final IGuidePresenter iGuidePresenter) {
        RequestParams requestParams = new RequestParams(URLPath.GUIDE_SELECTED_PATH);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                SelectedBeen selectedBeen = gson.fromJson(result, SelectedBeen.class);
                 iGuidePresenter.getSelectedBeenResult(selectedBeen);
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
