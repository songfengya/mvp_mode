package com.example.day37_dagger_butterknife_mvp_demo.presenter.impl;

import com.example.day37_dagger_butterknife_mvp_demo.model.IGuide_Model;
import com.example.day37_dagger_butterknife_mvp_demo.model.been.SelectedBeen;
import com.example.day37_dagger_butterknife_mvp_demo.model.impl.GuideModel;
import com.example.day37_dagger_butterknife_mvp_demo.presenter.IGuidePresenter;
import com.example.day37_dagger_butterknife_mvp_demo.view.IGuideViewResult;

/**
 * Created by Administrator on 2016/11/1.
 */
public class GuidePresenter implements IGuidePresenter {
   private IGuide_Model iGuide_model ;
    private IGuideViewResult iGuideViewResult;

    public GuidePresenter() {
    }

    public GuidePresenter(IGuideViewResult iGuideViewResult) {
        this.iGuideViewResult = iGuideViewResult;
    }

    public void runGuideModel(int pageno){
        iGuide_model = new GuideModel();
        iGuide_model.parserSelectedList(pageno,this);
    }
    @Override
    public void getSelectedBeenResult(SelectedBeen selectedBeen) {
        iGuideViewResult.getGuideViewResult(selectedBeen);
    }
}
