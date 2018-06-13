package com.example.fanqie.fragment;
/*
 *  包名: com.example.fanqie.fragment
 * Created by ASUS on 2018/4/23.
 *  描述: TODO
 */

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fanqie.R;
import com.example.fanqie.Utils.Utils;
import com.example.fanqie.Utils.provide;
import com.example.fanqie.View.CircleProgress;
import com.example.fanqie.activity.MainActivity;
import com.example.fanqie.model.Card;
import com.example.fanqie.model.Task;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

public class DayFragment extends BaseFragment {

    TextView finishtime;
    TextView date;
    EasyRecyclerView recyclerView;

    RecyclerArrayAdapter adapter;
    @Override
    public int getRootViewId() {
        return R.layout.fragment_day;
    }

    @Override
    public void initUI() {
        finishtime =(TextView) rootView.findViewById(R.id.finishtime);
        date =(TextView) rootView.findViewById(R.id.date);
        recyclerView = (EasyRecyclerView)rootView.findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        SpaceDecoration itemDecoration = new SpaceDecoration((int) Utils.convertDpToPixel(20,getContext()));
        itemDecoration.setPaddingEdgeSide(true);//是否为左右2边添加padding.默认true.
        itemDecoration.setPaddingStart(true);//是否在给第一行的item添加上padding(不包含header).默认true.
        itemDecoration.setPaddingHeaderFooter(true);//是否对Header于Footer有效,默认false.
        recyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void initData() {

        recyclerView.setAdapter(adapter = new RecyclerArrayAdapter<Card>(getContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new CardViewHolder(parent);
            }
        });

        adapter.addAll(provide.getdayList());





    }

    class CardViewHolder extends BaseViewHolder<Card> {

        private int preColor = Color.parseColor("#2c2200");
        private int progressColor = Color.parseColor("#6bb849");
        private int CircleColor = Color.parseColor("#CCCCCC");
        private int textColor = Color.parseColor("#9bb879");;
        private CircleProgress pv;


        private TextView desc;

        private TextView num;
        private TextView time;

        public CardViewHolder(ViewGroup parent) {
            super(parent, R.layout.fragment_day_item);

            pv = $(R.id.circleProgress);

            num= $(R.id.fanqienum);
            time= $(R.id.time);

            desc=$(R.id.desc);

        }

        @Override
        public void setData(Card data) {
            super.setData(data);

            pv.setTextColor(textColor).setCircleBackgroud(CircleColor)
                    .setPreProgress(progressColor).setProgress(preColor)
                    .setProdressWidth(50).setPaddingscale(0.8f);
            pv.setValue((int) (data.getFinishhour()/data.getHour()));

            switch (data.getType()){

                case 1:
                    num.setText(data.getFanqienum()+"");
                    time.setText(data.getHour()+"");
                    desc.setText("工作");
                    break;

                case 2:

                    num.setText(data.getFanqienum()+"");
                    time.setText(data.getHour()+"");
                    desc.setText("工作");
                    break;

                case 3:
                    num.setText(data.getFanqienum()+"");
                    time.setText(data.getHour()+"");
                    desc.setText("工作");
                    break;
                case 4:
                    num.setText(data.getFanqienum()+"");
                    time.setText(data.getHour()+"");
                    desc.setText("工作");
                    break;

                case 5:
                    num.setText(data.getFanqienum()+"");
                    time.setText(data.getHour()+"");
                    desc.setText("工作");
                    break;
            }

        }
    }

}
