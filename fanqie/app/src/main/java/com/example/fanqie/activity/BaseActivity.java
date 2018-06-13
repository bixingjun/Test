package com.example.fanqie.activity;
/*
 *  包名: com.example.fanqie.activity
 * Created by ASUS on 2018/4/23.
 *  描述: TODO
 */

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.fanqie.Presenter.BasePresenter;
import com.example.fanqie.R;

public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {

    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        mPresenter = createPresenter(); //创建Presenter
        mPresenter.attachView((V) this); //View与Presenter建立关联

        initUI();

    }

    protected abstract void initUI();

    protected abstract int getLayoutId();
    protected abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detechView();  //解除关联
    }
}
