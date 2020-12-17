package com.example.text_01.model;

import com.example.text_01.net.MainContacrt;
import com.example.text_01.presenter.NumPresenter;
import com.example.text_01.util.HttpCallBack;
import com.example.text_01.util.ResultUtil;

public class NumModel implements MainContacrt.getNumModel {
    private NumPresenter numPresenter;

    public NumModel(NumPresenter numPresenter) {

        this.numPresenter = numPresenter;
    }

    @Override
    public <T> void getNumber(String url, HttpCallBack<T> callBack) {
        ResultUtil.getInstance().get(url,callBack);
    }
}

