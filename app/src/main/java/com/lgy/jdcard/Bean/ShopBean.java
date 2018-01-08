package com.lgy.jdcard.Bean;

/**
 * Created by ${lgy} on 2018/1/809:55
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ShopBean {
    private String shopStoreId;

    private String shopId;

    private String shopUrl;

    private String shopName;

    private String shopPrice;

    private  int shopcount;

    private boolean shopSelect;

    private boolean shopStoreSelect;

    public boolean isShopSelect() {
        return shopSelect;
    }

    public void setShopSelect(boolean shopSelect) {
        this.shopSelect = shopSelect;
    }

    public boolean isShopStoreSelect() {
        return shopStoreSelect;
    }

    public void setShopStoreSelect(boolean shopStoreSelect) {
        this.shopStoreSelect = shopStoreSelect;
    }

    public String getShopStoreId() {
        return shopStoreId;
    }

    public void setShopStoreId(String shopStoreId) {
        this.shopStoreId = shopStoreId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(String shopPrice) {
        this.shopPrice = shopPrice;
    }

    public int getShopcount() {
        return shopcount;
    }

    public void setShopcount(int shopcount) {
        this.shopcount = shopcount;
    }
}
