package com.lgy.jdcard.utils.imageutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.lgy.jdcard.MainApplication;

import java.io.File;

/**
 * Created by ${lgy} on 2018/1/808:41
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class GlideImageLoader implements ImageLoader {
    RequestManager requestManager;
    @Override
    public void init(Context context) {
        if (context == null) {
            context = MainApplication.getInstance();
        }
        if(requestManager==null){
            requestManager= Glide.with(context);
        }

    }

    @Override
    public void displayImage(String url, ImageView imageView) {
        requestManager.load(url).into(imageView);
    }

    @Override
    public void displayImage(String url, ImageView imageView, int defaultImage) {
        requestManager.load(url).placeholder(defaultImage).into(imageView);
    }

    @Override
    public void displayImage(String url, ImageView imageView, int defaultImage, int errorImage) {
        requestManager.load(url).placeholder(defaultImage).error(defaultImage).into(imageView);
    }

    @Override
    public void displayImage(String url, ImageView imageView, boolean isNeedDefault) {

    }

    @Override
    public void displayImage(File file, ImageView imageView) {
        requestManager.load(file).into(imageView);
    }

    @Override
    public void displayImage(File file, ImageView imageView, int defaultImage) {
        requestManager.load(file).placeholder(defaultImage).into(imageView);
    }

    @Override
    public void displayImage(File file, ImageView imageView, int defaultImage, int errorImage) {
        requestManager.load(file).placeholder(defaultImage).error(defaultImage).into(imageView);
    }

    @Override
    public void displayImage(File file, ImageView imageView, boolean isNeedDefault) {

    }

    @Override
    public void displayImage(Bitmap bitmap, ImageView imageView) {
        requestManager.load(bitmap).into(imageView);
    }

    @Override
    public void displayImage(Bitmap bitmap, ImageView imageView, int defaultImage) {
        requestManager.load(bitmap).placeholder(defaultImage).into(imageView);
    }

    @Override
    public void displayImage(Bitmap bitmap, ImageView imageView, int defaultImage, int errorImage) {
        requestManager.load(bitmap).placeholder(defaultImage).error(defaultImage).into(imageView);
    }

    @Override
    public void displayImage(Bitmap bitmap, ImageView imageView, boolean isNeedDefault) {

    }
}
