package com.example.text_01.model;

import com.example.text_01.net.MainContacrt;
import com.example.text_01.presenter.BannerPresenter;
import com.example.text_01.util.HttpCallBack;
import com.example.text_01.util.ResultUtil;

public class BannerModel implements MainContacrt.getBannerModel{

    private BannerPresenter bannerPresenter;

    public BannerModel(BannerPresenter bannerPresenter) {

        this.bannerPresenter = bannerPresenter;
    }

    @Override
    public <T> void getBannerModel(String url, HttpCallBack<T> callBack) {
        ResultUtil.getInstance().get(url,callBack);
    }
}

