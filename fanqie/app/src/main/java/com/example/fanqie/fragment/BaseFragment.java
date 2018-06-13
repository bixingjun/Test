package com.example.fanqie.fragment;
/*
 *  包名: com.example.fanqie.fragment
 * Created by ASUS on 2018/4/24.
 *  描述: TODO
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment{



    public View rootView;

    private Unbinder mUnbinder;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(getRootViewId(),container,false);
        mUnbinder = ButterKnife.bind(this,rootView);



        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();

    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mUnbinder!=null)
            mUnbinder.unbind();
    }

    public abstract int getRootViewId();

    public abstract void initUI();

    public abstract void initData();

}
