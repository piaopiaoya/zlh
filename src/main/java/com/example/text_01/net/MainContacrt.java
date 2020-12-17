package com.example.text_01.net;

import com.example.text_01.bean.BannerBean;
import com.example.text_01.bean.ListBean;
import com.example.text_01.bean.NumBean;
import com.example.text_01.util.HttpCallBack;

public class MainContacrt {
    public interface getBannerView {
        void OnBannerOk(BannerBean bannerBean);

        void OnFail(String err);
    }

    public interface getBannerPresenter {
        void getBannerPresenter();
    }

    public interface getBannerModel {
        <T> void getBannerModel(String url, HttpCallBack<T> callBack);
    }


    public interface getRvView {
        void OnRvOK(ListBean listBean);

        void OnRvNO(String err);
    }

    public interface getRvModel {
        <T> void getRvModel(String url, HttpCallBack<T> callBack);
    }

    public interface getRvPresenter {
        void getRvPresenter();
    }

    public interface getNumView {
        void Numok(NumBean numBean);

        void NumNO(String err);
    }

    public interface getNumModel {
        <T> void getNumber(String url, HttpCallBack<T> callBack);
    }

    public interface getNumPresenter {
        void getNumberPresenter();
    }
}

