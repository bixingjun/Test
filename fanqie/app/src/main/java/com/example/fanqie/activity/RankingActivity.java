package com.example.fanqie.activity;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import com.example.fanqie.R;
import com.example.fanqie.adapter.ViewPageAdapter;
import com.example.fanqie.fragment.ContinuousUseFragment;
import com.example.fanqie.fragment.TomatoNumbeFragment;
import com.example.fanqie.fragment.UseTimeFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RankingActivity extends AppCompatActivity {

    private ArrayList<String> mTitleList = new ArrayList<>(3);
    private ArrayList<Fragment> mFragments = new ArrayList<>(3);
    private Unbinder bind;

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    ViewPageAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        bind = ButterKnife.bind(RankingActivity.this);
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
        mTitleList.add("连续使用榜");
        mTitleList.add("使用时长榜");
        mTitleList.add("番茄数榜");

        mFragments.add(new ContinuousUseFragment());
        mFragments.add(new UseTimeFragment());
        mFragments.add(new TomatoNumbeFragment());

    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
        }

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
