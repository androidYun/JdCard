package com.lgy.jdcard.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.lgy.jdcard.Bean.ShopBean;
import com.lgy.jdcard.Bean.ShopIdBean;
import com.lgy.jdcard.R;
import com.lgy.jdcard.utils.StringUtil;
import com.lgy.jdcard.weight.PlusReduceMedicinesView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${lgy} on 2018/1/809:59
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ShopCardAdapter extends RecyclerView.Adapter<ShopCardAdapter.DefineViewHolder> implements SectionIndexer {

    private List<ShopBean> mDataList;

    private Context mContext;

    private LayoutInflater layoutInflater;

    private List<ShopIdBean> shopIdList;


    public ShopCardAdapter(Context mContext, List<ShopBean> mDataList) {
        this.mDataList = mDataList;
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
        shopIdList = new ArrayList<>();
        for (int i = 0; i < mDataList.size(); i++) {
            if (!isExitShopId(mDataList.get(i).getShopStoreId())) {
                ShopIdBean shopIdBean = new ShopIdBean();
                shopIdBean.setPosition(i);
                shopIdBean.setSectionIndex(shopIdList.size());
                shopIdBean.setGetShopStoreId(mDataList.get(i).getShopStoreId());
                shopIdList.add(shopIdBean);
            }
        }
    }

    public boolean isExitShopId(String shopStoreId) {
        for (int i = 0; i < shopIdList.size(); i++) {
            if (shopStoreId.equals(shopIdList.get(i).getGetShopStoreId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public DefineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_shop_card, parent, false);
        return new DefineViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final DefineViewHolder holder, int position) {
        if (holder.viewMedicines.getCountEv().getTag() instanceof TextWatcher) {
            holder.viewMedicines.getCountEv().removeTextChangedListener((TextWatcher) (holder.viewMedicines.getCountEv().getTag()));
        }
        final ShopBean shopBean = mDataList.get(position);
        holder.tvShopName.setText(shopBean.getShopName());
        int count = shopBean.getShopcount();
        if (count == 0) {
            count = 1;
        }
        holder.viewMedicines.setCurrentCount(count);
        holder.viewMedicines.getCountEv().setText(count + "");
        holder.viewMedicines.getCountEv().requestFocus();
        final TextWatcher watcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (StringUtil.isEmpty(s.toString())) {
                    shopBean.setShopcount(1);
                    holder.viewMedicines.setCurrentCount(0);
                } else {
                    if (s.toString().startsWith("0") && s.toString().trim().length() > 1) {
                        holder.viewMedicines.getCountEv().setText(s.subSequence(1, 2));
                        holder.viewMedicines.getCountEv().setSelection(1);
                        return;
                    } else {
                        int countNum = Integer.valueOf(s.toString());
                        shopBean.setShopcount(countNum);
                        holder.viewMedicines.setCurrentCount(countNum);
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        holder.viewMedicines.getCountEv().addTextChangedListener(watcher);
        holder.viewMedicines.getCountEv().setTag(watcher);
        int section = getSectionForPosition(position);
        //根据月份筛选
        if (position == getPositionForSection(section)) {
            holder.lvTitle.setVisibility(View.VISIBLE);
        } else {
            holder.lvTitle.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class DefineViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_all_select)
        ImageView ivAllSelect;
        @BindView(R.id.tv_shopstore_name)
        TextView tvShopstoreName;
        @BindView(R.id.lv_title)
        LinearLayout lvTitle;
        @BindView(R.id.iv_select)
        ImageView ivSelect;
        @BindView(R.id.iv_shop_head)
        ImageView ivShopHead;
        @BindView(R.id.tv_shop_name)
        TextView tvShopName;
        @BindView(R.id.view_medicines)
        PlusReduceMedicinesView viewMedicines;

        public DefineViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    //返回一个代表sections列表的非空的数组对象
    //当滑动的时候，这个list view可以调用toString()来显示预览文本。
    //例如，一个adapter可以返回代表字母表中字母的字符串数组，或者返回section titles的对象数组
    @Override
    public Object[] getSections() {
        for (int i = 0; i < mDataList.size(); i++) {

        }
        return new Object[0];
    }

    //提供section索引，通过section数组对象，返回adapter中section开始的位置
    @Override
    public int getPositionForSection(int sectionIndex) {
        return shopIdList.get(sectionIndex).getPosition();
    }

    //提供adapter中的位置，在section数组对象中返回相应的section索引
    //如果postion位置在索引开始位置之前，则返回0
    @Override
    public int getSectionForPosition(int position) {
        String shopStoreId = mDataList.get(position).getShopStoreId();
        for (int i = 0; i < shopIdList.size(); i++) {
            if (shopIdList.get(i).getGetShopStoreId().equals(shopStoreId)) {
                return shopIdList.get(i).getSectionIndex();
            }
        }
        return 0;
    }
}
