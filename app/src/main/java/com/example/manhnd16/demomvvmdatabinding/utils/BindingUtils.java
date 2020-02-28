package com.example.manhnd16.demomvvmdatabinding.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.manhnd16.demomvvmdatabinding.adapter.MyAdapter;

public class BindingUtils {

    @BindingAdapter({"imageUrl"})
    public static void loadimage(ImageView imageView, String imageUrl){
        Glide.with(imageView.getContext()).load(imageUrl).apply(new RequestOptions().circleCrop()).into(imageView);
    }

    @BindingAdapter("setAdapterMyList")
    public static void setAdapterMyList(RecyclerView view, MyAdapter adapter) {
        view.setLayoutManager(new LinearLayoutManager(view.getContext()));
        view.setAdapter(adapter);
    }
}
