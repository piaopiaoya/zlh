package com.example.text_01.util;

public interface HttpCallBack<T> {
    void OnSuccess(T t);
    void OnFail(String err);
}

