package com.lgy.jdcard.utils.imageutils;

/**
 * Created by ${lgy} on 2018/1/808:33
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import java.io.File;

/**
 * 图片加载器功能接口；
 * 添加或者替换新的图片加载器实现该接口即可
 */
public interface ImageLoader {
    /**
     * 初始化上下文
     * @param context
     */
     void init(Context context);

    /**
     * 显示一个网络图片
     * @param url
     * @param imageView
     */
     void displayImage(String url, ImageView imageView);

    /**
     * 显示一个网络图片  并且图片显示失败显示默认图片
     * @param url
     * @param imageView
     */
    void displayImage(String url, ImageView imageView,int defaultImage);

    /**
     * 显示一个网络图片  并且图片显示失败显示默认图片或者是错误图片
     * @param url
     * @param imageView
     */
    void displayImage(String url, ImageView imageView,int defaultImage,int errorImage);

    /**
     * 显示一个网络图片  显示公共默认图片
     * @param url
     * @param imageView
     */
    void displayImage(String url, ImageView imageView,boolean isNeedDefault);

    /**
     *  显示本地图片
     * @param file
     * @param imageView
     */
    void displayImage(File file, ImageView imageView);


    /**
     * 显示一个网络图片  并且图片显示失败显示默认图片
     * @param file
     * @param imageView
     */
    void displayImage(File file, ImageView imageView,int defaultImage);

    /**
     * 显示一个网络图片  并且图片显示失败显示默认图片或者是错误图片
     * @param file
     * @param imageView
     */
    void displayImage(File file, ImageView imageView,int defaultImage,int errorImage);

    /**
     * 显示一个网络图片  显示公共默认图片
     * @param file
     * @param imageView
     */
    void displayImage(File file, ImageView imageView,boolean isNeedDefault);

    /**
     *  显示本地图片
     * @param bitmap
     * @param imageView
     */
    void displayImage(Bitmap bitmap, ImageView imageView);


    /**
     * 显示一个网络图片  并且图片显示失败显示默认图片
     * @param bitmap
     * @param imageView
     */
    void displayImage(Bitmap bitmap, ImageView imageView,int defaultImage);

    /**
     * 显示一个网络图片  并且图片显示失败显示默认图片或者是错误图片
     * @param bitmap
     * @param imageView
     */
    void displayImage(Bitmap bitmap, ImageView imageView,int defaultImage,int errorImage);

    /**
     * 显示一个网络图片  显示公共默认图片
     * @param bitmap
     * @param imageView
     */
    void displayImage(Bitmap bitmap, ImageView imageView,boolean isNeedDefault);
}
