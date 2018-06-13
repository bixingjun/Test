package com.example.fanqie.fragment;
/*
 *  包名: com.example.fanqie.fragment
 * Created by ASUS on 2018/4/17.
 *  描述: TODO
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fanqie.R;

public class UseTimeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_continuoususe, null);

        return view;

    }
}
