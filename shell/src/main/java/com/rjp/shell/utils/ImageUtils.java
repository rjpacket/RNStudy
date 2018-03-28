package com.rjp.shell.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageUtils {

    public static void load(Context context, String imageUrl, ImageView imageView){
        Glide.with(context)
                .load(imageUrl)
                .into(imageView);
    }

    public void load(Context context, String imageUrl, int defaultPic, int errorPic, ImageView imageView){
        Glide.with(context)
                .load(imageUrl)
                .placeholder(defaultPic)
                .error(errorPic)
                .into(imageView);
    }
}
