package com.example.text_01.model;

import com.example.text_01.net.MainContacrt;
import com.example.text_01.presenter.ListPresenter;
import com.example.text_01.util.HttpCallBack;
import com.example.text_01.util.ResultUtil;

public class ListModel implements MainContacrt.getRvModel {
    private ListPresenter listPresenter;

    public ListModel(ListPresenter listPresenter) {

        this.listPresenter = listPresenter;
    }

    @Override
    public <T> void getRvModel(String url, HttpCallBack<T> callBack) {
        ResultUtil.getInstance().get(url,callBack);
    }
}

