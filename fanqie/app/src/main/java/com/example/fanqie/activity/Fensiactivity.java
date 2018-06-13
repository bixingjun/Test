package com.example.fanqie.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.example.fanqie.R;
import com.example.fanqie.adapter.ViewPageAdapter;
import com.example.fanqie.fragment.ContinuousUseFragment;
import com.example.fanqie.fragment.DayFragment;
import com.example.fanqie.fragment.MonthFragment;
import com.example.fanqie.fragment.TomatoNumbeFragment;
import com.example.fanqie.fragment.UseTimeFragment;
import com.example.fanqie.fragment.WeekFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fensiactivity extends AppCompatActivity {


    private ArrayList<String> mTitleList = new ArrayList<>(3);
    private ArrayList<Fragment> mFragments = new ArrayList<>(3);


    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Unbinder bind;
    ViewPageAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fensiactivity);
        bind = ButterKnife.bind(Fensiactivity.this);

        initToolbar();
        initFragmentList();
        initView();

    }

    private void initView() {

        myAdapter = new ViewPageAdapter(getSupportFragmentManager(), mFragments, mTitleList);
        viewpager.setAdapter(myAdapter);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tablayout.setupWithViewPager(viewpager);

    }

    private void initFragmentList() {
        if (mTitleList.size() != 0) {
            return;
        }
        mTitleList.add("日");
        mTitleList.add("周");
        mTitleList.add("月");

        mFragments.add(new DayFragment());
        mFragments.add(new WeekFragment());
        mFragments.add(new MonthFragment());

    }

    private void initToolbar() {
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true);
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);

        }
        //设置显示三横杠
       toolbar.setNavigationIcon(R.mipmap.titlebar_menu);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

}
