package com.gr.light.advanceview.recyclerview;


import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.gr.light.R;
import com.gr.light.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WssRecyclerViewActivity extends BaseActivity {

    List<Country> countryList = new ArrayList<>();
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    FreshAdapter freshAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDatas();
        initView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wss_recycler_view;
    }

    private void initDatas() {
        countryList.add(new Country("阿尔巴尼亚", R.drawable.albania));
        countryList.add(new Country("安道尔", R.drawable.andorra));
        countryList.add(new Country("奥地利", R.drawable.austria));
        countryList.add(new Country("白俄罗斯", R.drawable.belarus));
        countryList.add(new Country("保加利亚", R.drawable.belgium));
        countryList.add(new Country("法国", R.drawable.france));
        countryList.add(new Country("德国", R.drawable.germany));
        countryList.add(new Country("意大利", R.drawable.italy));
        countryList.add(new Country("葡萄牙", R.drawable.portugal));
        countryList.add(new Country("罗马尼亚", R.drawable.romania));
        countryList.add(new Country("俄罗斯", R.drawable.russia));
        countryList.add(new Country("塞尔维亚", R.drawable.serbia));
        countryList.add(new Country("西班牙", R.drawable.spain));
        countryList.add(new Country("英国", R.drawable.united_kingdom));
    }

    private void initView() {
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
//        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        assert recyclerView != null;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        FreshAdapter freshAdapter = new FreshAdapter(countryList);
        recyclerView.setAdapter(freshAdapter);

        //下拉刷新
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }

    // wss15155
    private void refresh(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        freshAdapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

}
