package com.lgy.jdcard;

import android.app.Application;

/**
 * Created by ${lgy} on 2018/1/808:44
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class MainApplication extends Application {
    private static MainApplication mContext;
    public static MainApplication getInstance() {
        return mContext;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
    }
}
