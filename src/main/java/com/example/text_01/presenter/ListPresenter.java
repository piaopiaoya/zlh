package com.example.text_01.presenter;

import com.example.text_01.bean.ListBean;
import com.example.text_01.fragment.HomeFragment;
import com.example.text_01.model.ListModel;
import com.example.text_01.net.MainContacrt;
import com.example.text_01.util.HttpCallBack;
import com.example.text_01.util.UrlUtil;

public class ListPresenter implements MainContacrt.getRvPresenter {
    private HomeFragment homeFragment;
    private final ListModel listModel;

    public ListPresenter(HomeFragment homeFragment) {
        listModel = new ListModel(this);
        this.homeFragment = homeFragment;
    }

    @Override
    public void getRvPresenter() {
        listModel.getRvModel(UrlUtil.RV, new HttpCallBack<ListBean>() {
            @Override
            public void OnSuccess(ListBean listBean) {
                homeFragment.OnRvOK(listBean);
            }

            @Override
            public void OnFail(String err) {
homeFragment.OnRvNO(err);
            }
        });
    }
}

