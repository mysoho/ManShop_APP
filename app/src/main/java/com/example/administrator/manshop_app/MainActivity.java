package com.example.administrator.manshop_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import home.fragments.Fragment_Home;
import mine.fragments.Fragment_mine;
import shop.fragments.Fragment_shop;
import sort.fragments.Fragment_sort;

public class MainActivity extends FragmentActivity {


    List<Fragment> list;
    FragmentManager manager;
    Fragment_Home frag_home;
    Fragment_sort frag_sort;
    Fragment_shop frag_shop;
    Fragment_mine frag_me;
    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.home)
    RadioButton home;
    @BindView(R.id.sort)
    RadioButton sort;
    @BindView(R.id.shop)
    RadioButton shop;
    @BindView(R.id.me)
    RadioButton me;
    @BindView(R.id.group)
    RadioGroup group;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        manager = getSupportFragmentManager();
        frag_home=new Fragment_Home();
        frag_sort=new Fragment_sort();
        frag_shop=new Fragment_shop();
        frag_me=new Fragment_mine();



    }


    public void addfragment(Fragment fragment){
        FragmentTransaction tran = manager.beginTransaction();
        tran.replace(R.id.frame, fragment);
        tran.commit();
    }

    @OnClick({R.id.home, R.id.sort, R.id.shop, R.id.me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home:
                addfragment(frag_home);
                break;
            case R.id.sort:
                addfragment(frag_sort);
                break;
            case R.id.shop:
                 addfragment(frag_shop);
                break;
            case R.id.me:
                addfragment(frag_me);
                break;
        }
    }
}
