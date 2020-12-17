package com.example.text_01.presenter;

import com.example.text_01.MainActivity;
import com.example.text_01.bean.BannerBean;
import com.example.text_01.model.BannerModel;
import com.example.text_01.net.MainContacrt;
import com.example.text_01.util.HttpCallBack;
import com.example.text_01.util.UrlUtil;

public class BannerPresenter implements MainContacrt.getBannerPresenter {


    private MainActivity mainActivity;
    private final BannerModel bannerModel;

    public BannerPresenter(MainActivity mainActivity) {
        bannerModel = new BannerModel(this);
        this.mainActivity = mainActivity;
    }

    @Override
    public void getBannerPresenter() {
        bannerModel.getBannerModel(UrlUtil.BANNER, new HttpCallBack<BannerBean>() {
            @Override
            public void OnSuccess(BannerBean bannerBean) {
                mainActivity.OnBannerOk(bannerBean);
            }

            @Override
            public void OnFail(String err) {
                mainActivity.OnFail(err);
            }
        });
    }
}

