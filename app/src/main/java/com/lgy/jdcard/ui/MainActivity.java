package com.lgy.jdcard.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lgy.jdcard.Bean.ShopBean;
import com.lgy.jdcard.R;
import com.lgy.jdcard.ui.adapter.ShopCardAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.rv_card)
    RecyclerView rvCard;
    private ShopCardAdapter shopCardAdapter;
    private List<ShopBean> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    public void initData() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ShopBean shopBean = new ShopBean();
            shopBean.setShopId("fdgvdfgdf" + i);
            shopBean.setShopName("炝锅面");
            shopBean.setShopPrice("123345");
            shopBean.setShopStoreId("5114515"+i);
            shopBean.setShopUrl("dsf");
            mDataList.add(shopBean);
        }
        rvCard.setLayoutManager(new LinearLayoutManager(this));
        shopCardAdapter = new ShopCardAdapter(this, mDataList);
        rvCard.setAdapter(shopCardAdapter);
    }
}
