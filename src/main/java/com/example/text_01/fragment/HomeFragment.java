package com.example.text_01.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.text_01.R;
import com.example.text_01.adapter.RvAdapter;
import com.example.text_01.bean.ListBean;
import com.example.text_01.net.MainContacrt;
import com.example.text_01.presenter.ListPresenter;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements MainContacrt.getRvView {
    private RecyclerView rv_home;
    private ArrayList<ListBean.NewsBean> list;
    private RvAdapter adapter;
    private ListPresenter listPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);
        listPresenter = new ListPresenter(this);
        listPresenter.getRvPresenter();
        initView(view);
        return view;
    }

    private void initView(View view) {
        rv_home = view.findViewById(R.id.rv_home);
        rv_home.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new RvAdapter(getActivity(), list);
        rv_home.setAdapter(adapter);
        rv_home.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void OnRvOK(ListBean listBean) {
        list.addAll(listBean.getNews());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnRvNO(String err) {

    }
}

