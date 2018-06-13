package com.example.fanqie.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fanqie.R;
import com.example.fanqie.Utils.Utils;
import com.example.fanqie.Utils.provide;
import com.example.fanqie.model.Task;
import com.jaeger.library.StatusBarUtil;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{

    private EasyRecyclerView recyclerView;
    private RecyclerArrayAdapter adapter;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initRecyclerView();
        initData();
        onRefresh();
    }

    private void initRecyclerView() {
        recyclerView = (EasyRecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        SpaceDecoration itemDecoration = new SpaceDecoration((int) Utils.convertDpToPixel(20,this));
        itemDecoration.setPaddingEdgeSide(true);//是否为左右2边添加padding.默认true.
        itemDecoration.setPaddingStart(true);//是否在给第一行的item添加上padding(不包含header).默认true.
        itemDecoration.setPaddingHeaderFooter(true);//是否对Header于Footer有效,默认false.
        recyclerView.addItemDecoration(itemDecoration);
    }


    private void initData() {
        recyclerView.setAdapterWithProgress(adapter = new RecyclerArrayAdapter<Task>(this) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new TaskViewHolder(parent);
            }
        });

        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
        adapter.setOnItemLongClickListener(new RecyclerArrayAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(int position) {
                adapter.remove(position);
                return true;
            }
        });
        adapter.setError(R.layout.view_error, new RecyclerArrayAdapter.OnErrorListener() {
            @Override
            public void onErrorShow() {
                adapter.resumeMore();
            }

            @Override
            public void onErrorClick() {
                adapter.resumeMore();
            }
        });

        recyclerView.setRefreshListener(this);


    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.clear();
                //刷新
                adapter.addAll(provide.getList());
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //刷新
                adapter.addAll(provide.getList());
            }
        }, 2000);
    }

    public class TaskViewHolder extends BaseViewHolder<Task> {
        private TextView type;
        private TextView desc;
        private TextView content;
        private LinearLayout linearLayout;
        ImageView photo;
        ImageView type_photo;

        public TaskViewHolder(ViewGroup parent) {
            super(parent, R.layout.item);

            photo= $(R.id.photo);
            type_photo=$(R.id.type_photo);
             type = $(R.id.type);
            content=$(R.id.content);
            desc=$(R.id.content);
            linearLayout=$(R.id.LLayout);
        }

        @Override
        public void setData(Task data) {
            super.setData(data);


            switch (data.getType()){

                case 1:
                    Glide.with(getContext())
                            .load(R.drawable.default_image)
                            .placeholder(R.drawable.default_image)
                            .into(type_photo);

                    type.setText("工作");
                    break;

                case 2:

                    Glide.with(getContext())
                            .load(R.drawable.default_image)
                            .placeholder(R.drawable.default_image)
                            .into(type_photo);
                    type.setText("工作");
                    break;

                case 3:

                    Glide.with(getContext())
                            .load(R.drawable.default_image)
                            .placeholder(R.drawable.default_image)
                            .into(type_photo);
                    type.setText("工作");
                    break;

                case 4:

                    Glide.with(getContext())
                            .load(R.drawable.default_image)
                            .placeholder(R.drawable.default_image)
                            .into(type_photo);
                    type.setText("工作");
                    break;

                case 5:

                    Glide.with(getContext())
                            .load(R.drawable.default_image)
                            .placeholder(R.drawable.default_image)
                            .into(type_photo);
                    type.setText("工作");
                    break;

            }

            content.setText(data.getContent());

            desc.setText(data.getDesc());

            linearLayout.removeAllViews();

            for(int i=1;i<=data.getNum();i++){

                ImageView imageView=new ImageView(MainActivity.this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
                params.setMargins(10,0,10,0);
                imageView.setLayoutParams(params);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                //加载图片
                Glide.with(getContext())
                        .load(R.drawable.default_image)
                        .placeholder(R.drawable.default_image)
                        .into(imageView);
                linearLayout.addView(imageView);
            }

            Glide.with(getContext())
                    .load(data.getPhoto())
                    .asBitmap()
                    .into(photo);


            Log.i("sss",data.getPhoto());

        }
    }
    
    

    private void initView() {

        StatusBarUtil.setColorForDrawerLayout(this, (DrawerLayout) findViewById(R.id.drawer_layout), Color.RED);
     /*   StatusBarUtil.setColor(this,Color.GREEN);*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        ActionBar actionBar = getSupportActionBar();

        ///设置显示返回箭头
        actionBar.setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.mipmap.titlebar_menu);
        //设置显示三横杠


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);







    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_layout_one, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_ranking) {
            Intent intent = new Intent(MainActivity.this, RankingActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {

        Intent intent;
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        switch (item.getItemId()){
            case R.id.nav_task:


                break;

            case R.id.nav_tongji:
                intent=new Intent(MainActivity.this,Tongjiactivity.class);
                startActivity(intent);


                break;
            case R.id.nav_fensi:
                intent=new Intent(MainActivity.this,Fensiactivity.class);
                startActivity(intent);


                break;
            case R.id.nav_fankui:
                intent=new Intent(MainActivity.this,Tongjiactivity.class);
                startActivity(intent);


                break;
            case R.id.nav_setting:
                intent=new Intent(MainActivity.this,Tongjiactivity.class);
                startActivity(intent);



                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        item.setChecked(false);
        return true;

    }
}
