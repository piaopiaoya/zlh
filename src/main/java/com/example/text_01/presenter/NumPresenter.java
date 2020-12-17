package com.example.text_01.presenter;

import com.example.text_01.bean.NumBean;
import com.example.text_01.fragment.CollFragment;
import com.example.text_01.model.NumModel;
import com.example.text_01.net.MainContacrt;
import com.example.text_01.util.HttpCallBack;
import com.example.text_01.util.UrlUtil;

public class NumPresenter implements MainContacrt.getNumPresenter {
    private CollFragment collFragment;
    private final NumModel numModel;

    public NumPresenter(CollFragment collFragment) {

        numModel = new NumModel(this);
        this.collFragment = collFragment;
    }

    @Override
    public void getNumberPresenter() {
        numModel.getNumber(UrlUtil.NUMBER, new HttpCallBack<NumBean>() {
            @Override
            public void OnSuccess(NumBean numBean) {
                collFragment.Numok(numBean);
            }

            @Override
            public void OnFail(String err) {
collFragment.NumNO(err);
            }
        });
    }
}

