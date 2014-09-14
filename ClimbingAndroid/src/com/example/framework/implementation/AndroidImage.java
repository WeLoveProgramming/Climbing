package com.example.framework.implementation;

import android.graphics.Bitmap;

import com.example.testandroid.Image;
import com.example.testandroid.Graphics.ImageFormat;

public class AndroidImage implements Image {
    Bitmap bitmap;
    ImageFormat format;
   
    public AndroidImage(Bitmap bitmap, ImageFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    public int getWidth() {
        return bitmap.getWidth();
    }

    public int getHeight() {
        return bitmap.getHeight();
    }

    public ImageFormat getFormat() {
        return format;
    }

    public void dispose() {
        bitmap.recycle();
    }      
}
