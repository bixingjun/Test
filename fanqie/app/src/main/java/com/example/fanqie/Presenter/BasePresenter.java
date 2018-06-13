package com.example.fanqie.Presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/*
 *  包名: com.example.fanqie.Presenter
 * Created by ASUS on 2018/4/24.
 *  描述: TODO
 */
public class BasePresenter<T> {

    protected Reference<T> mViewRef;  //View接口类型的弱引用

    /**
     * 建立关联
     * @param view
     */
    public void attachView(T view){
        mViewRef = new WeakReference<T>(view);
    }

    /**
     * 获取View
     * @return
     */
    protected T getView(){
        return mViewRef.get();
    }

    /**
     * 判断是否与View建立关联
     * @return
     */
    public boolean isViewAttach(){
        return mViewRef != null && mViewRef.get() != null;
    }

    /**
     * 解除关联
     */
    public void detechView(){
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }
}