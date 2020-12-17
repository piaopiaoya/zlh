package com.example.text_01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.text_01.R;
import com.example.text_01.bean.NumBean;

import java.util.ArrayList;

public class RvBdapter extends RecyclerView.Adapter<RvBdapter.ViewHolder> {
    private Context context;
    private ArrayList<NumBean.StudenlistBean> list;


    public RvBdapter(Context context, ArrayList<NumBean.StudenlistBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_coll, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvJineng.setText("技能成绩："+list.get(position).getTheory());
        holder.tvLilun.setText("理论成绩："+list.get(position).getSkill());
        holder.tvName.setText("姓名："+list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvLilun;
        private TextView tvJineng;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvLilun = (TextView) itemView.findViewById(R.id.tv_lilun);
            tvJineng = (TextView) itemView.findViewById(R.id.tv_jineng);
        }
    }
}

