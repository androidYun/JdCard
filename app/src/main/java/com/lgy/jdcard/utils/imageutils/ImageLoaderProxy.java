package com.lgy.jdcard.utils.imageutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by ${lgy} on 2018/1/808:51
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ImageLoaderProxy implements ImageLoader{
    private ImageLoader imageLoader;

    private static ImageLoaderProxy imageLoaderProxy;

    public static ImageLoaderProxy getInstace() {
        if(imageLoaderProxy==null){
            imageLoaderProxy=  CreateImageLoaderProxy.IMAGE_LOADER_PROXY;
        }
        return imageLoaderProxy;
    }

    static class CreateImageLoaderProxy {
        static final ImageLoaderProxy IMAGE_LOADER_PROXY = new ImageLoaderProxy();
    }

    public ImageLoaderProxy() {
        this.imageLoader = new GlideImageLoader();
    }

    @Override
    public void init(Context context) {
        imageLoader.init(context);
    }

    @Override
    public void displayImage(String url, ImageView imageView) {
        imageLoader.displayImage(url,imageView);
    }

    @Override
    public void displayImage(String url, ImageView imageView, int defaultImage) {
        imageLoader.displayImage(url,imageView,defaultImage);
    }

    @Override
    public void displayImage(String url, ImageView imageView, int defaultImage, int errorImage) {
        imageLoader.displayImage(url,imageView,defaultImage,errorImage);
    }

    @Override
    public void displayImage(String url, ImageView imageView, boolean isNeedDefault) {

    }

    @Override
    public void displayImage(File file, ImageView imageView) {
        imageLoader.displayImage(file,imageView);
    }

    @Override
    public void displayImage(File file, ImageView imageView, int defaultImage) {
        imageLoader.displayImage(file,imageView,defaultImage);
    }

    @Override
    public void displayImage(File file, ImageView imageView, int defaultImage, int errorImage) {
        imageLoader.displayImage(file,imageView,defaultImage,errorImage);
    }

    @Override
    public void displayImage(File file, ImageView imageView, boolean isNeedDefault) {
        imageLoader.displayImage(file,imageView,isNeedDefault);
    }

    @Override
    public void displayImage(Bitmap bitmap, ImageView imageView) {
        imageLoader.displayImage(bitmap,imageView);
    }

    @Override
    public void displayImage(Bitmap bitmap, ImageView imageView, int defaultImage) {
        imageLoader.displayImage(bitmap,imageView,defaultImage);
    }

    @Override
    public void displayImage(Bitmap bitmap, ImageView imageView, int defaultImage, int errorImage) {
        imageLoader.displayImage(bitmap,imageView,defaultImage,errorImage);
    }

    @Override
    public void displayImage(Bitmap bitmap, ImageView imageView, boolean isNeedDefault) {
        imageLoader.displayImage(bitmap,imageView,isNeedDefault);
    }
}
