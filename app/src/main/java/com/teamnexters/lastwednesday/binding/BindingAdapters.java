package com.teamnexters.lastwednesday.binding;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by JY on 2018-02-23.
 */

public class BindingAdapters {

    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}
