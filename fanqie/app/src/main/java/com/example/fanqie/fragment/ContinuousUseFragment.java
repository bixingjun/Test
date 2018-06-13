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
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fanqie.R;
import com.example.fanqie.Utils.provide;
import com.example.fanqie.model.ContinuousUseModel;

import com.example.fanqie.model.TimeUse;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;


import java.util.ArrayList;

public class ContinuousUseFragment extends Fragment {
    private EasyRecyclerView recyclerView;
    private ArrayList<TimeUse> arrayList=new ArrayList();
    RecyclerArrayAdapter<ContinuousUseModel> adapter;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         view = inflater.inflate(R.layout.fragment_continuoususe, null);


        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();

        initData();
        setData();
        initHead();
    }

    private void initHead() {
        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {

            private TextView ranking;
            private TextView name;
            private TextView time;
            private ImageView head;
            @Override
            public View onCreateView(ViewGroup parent) {
                View headView = View.inflate(getContext(), R.layout.item_continuoususe_head,null);
                ranking=headView.findViewById(R.id.ranking);
                name=headView.findViewById(R.id.name);
                time=headView.findViewById(R.id.time);
                head=headView.findViewById(R.id.head);

                name.setText(provide.gettimeList().get(1).getName());
                ranking.setText(provide.gettimeList().get(1).getRank()+"");


                StringBuffer stringBuffer=new StringBuffer();

                stringBuffer.append(provide.gettimeList().get(1).getTime());

                time.setText(stringBuffer);

                Glide.with(getContext())
                        .load(provide.gettimeList().get(1).getHeadurl())
                        .placeholder(R.drawable.default_image)
                        .into(head);
                return headView;
            }

            @Override
            public void onBindView(View headerView) {

            }
        });
    }

    private void setData() {
        adapter.addAll(provide.gettimeList());
    }

    private void initRecyclerView() {
        recyclerView = (EasyRecyclerView)view.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);



    }

    private void initData() {



        recyclerView.setAdapterWithProgress(adapter=new RecyclerArrayAdapter<ContinuousUseModel>(getContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new ContinuousUseViewHolder(parent);
            }
        });






    }




     class ContinuousUseViewHolder extends BaseViewHolder<ContinuousUseModel> {


        private TextView ranking;
        private TextView name;
        private TextView time;
        private ImageView head;


        public ContinuousUseViewHolder(ViewGroup parent) {
            super(parent,R.layout.item_continuoususe);


            ranking= $(R.id.ranking);
            name=$(R.id.name);
            time = $(R.id.time);
            head=$(R.id.head);

        }

        @Override
        public void setData(ContinuousUseModel data) {
            super.setData(data);

            ranking.setText(data.getRank()+"");

            name.setText(data.getName());

            StringBuffer stringBuffer=new StringBuffer();

            stringBuffer.append(data.getTime()+" 天");

            time.setText(stringBuffer);

            Glide.with(getContext())
                    .load(data.getHeadurl())
                    .placeholder(R.drawable.default_image)
                    .into(head);

        }
    }



}
