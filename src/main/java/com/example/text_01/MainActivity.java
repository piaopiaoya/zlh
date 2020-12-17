package com.example.text_01;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.text_01.adapter.VpAdapter;
import com.example.text_01.bean.BannerBean;
import com.example.text_01.fragment.CollFragment;
import com.example.text_01.fragment.HomeFragment;
import com.example.text_01.net.MainContacrt;
import com.example.text_01.presenter.BannerPresenter;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContacrt.getBannerView {

    private Banner banner;
    private TabLayout tl;
    private ViewPager vp;
    private HomeFragment homeFragment;
    private CollFragment collFragment;
    private VpAdapter adapter;
    private ArrayList<BannerBean.BannerlistBean> list;
    private BannerPresenter bannerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bannerPresenter = new BannerPresenter(this);
        bannerPresenter.getBannerPresenter();
        initView();
        initData();
    }

    private void initData() {
        homeFragment = new HomeFragment();
        collFragment = new CollFragment();

        ArrayList<String> titles = new ArrayList<>();
        titles.add("学校新闻");
        titles.add("班级成绩");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(homeFragment);
        fragments.add(collFragment);

        adapter = new VpAdapter(getSupportFragmentManager(), fragments, titles);
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.banner);
        tl = (TabLayout) findViewById(R.id.tl);
        vp = (ViewPager) findViewById(R.id.vp);
        list = new ArrayList<>();
    }

    @Override
    public void OnBannerOk(BannerBean bannerBean) {
        banner.setImages(bannerBean.getBannerlist());
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                BannerBean.BannerlistBean db = (BannerBean.BannerlistBean) path;
                Glide.with(context).load(db.getImageurl()).into(imageView);
            }
        }).start();
    }

    @Override
    public void OnFail(String err) {

    }
}