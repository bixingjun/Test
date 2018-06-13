package com.example.fanqie.adapter;
/*
 *  包名: com.example.fanqie.adapter
 * Created by ASUS on 2018/4/17.
 *  描述: TODO
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private List<String> mTitleList;

    public ViewPageAdapter(FragmentManager fm,List<Fragment> fragmentList,List<String> mTitleList) {
        super(fm);
        this.fragmentList=fragmentList;
        this.mTitleList=mTitleList;
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitleList != null) {
            return mTitleList.get(position);
        } else {
            return "";
        }
    }
}
