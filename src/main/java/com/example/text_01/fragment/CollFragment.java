package com.example.text_01.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.text_01.R;
import com.example.text_01.adapter.RvBdapter;
import com.example.text_01.bean.NumBean;
import com.example.text_01.net.MainContacrt;
import com.example.text_01.presenter.NumPresenter;

import java.util.ArrayList;

public class CollFragment extends Fragment implements MainContacrt.getNumView {

    //我现在要开始改代码了哦

    private RecyclerView rv_coll;
    private ArrayList<NumBean.StudenlistBean> list;
    private RvBdapter bdapter;
    private NumPresenter numPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_coll, null);
        numPresenter = new NumPresenter(this);
        numPresenter.getNumberPresenter();
        initView(view);
        return view;
    }

    private void initView(View view) {
        rv_coll = view.findViewById(R.id.rv_coll);
        rv_coll.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        bdapter = new RvBdapter(getActivity(), list);
        rv_coll.setAdapter(bdapter);
//设置下面的线
        rv_coll.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void Numok(NumBean numBean) {
        list.addAll(numBean.getStudenlist());
        bdapter.notifyDataSetChanged();
    }

    @Override
    public void NumNO(String err) {
        Toast.makeText(getActivity(), "num错误信息", Toast.LENGTH_SHORT).show();
    }
}

