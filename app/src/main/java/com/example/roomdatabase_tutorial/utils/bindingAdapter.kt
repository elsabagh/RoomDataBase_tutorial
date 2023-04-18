package com.example.roomdatabase_tutorial.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase_tutorial.ui.base.BaseAdapter

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?){
    if (items != null){
        (view.adapter as BaseAdapter<T>?)?.setItems(items)
    }else{
        (view.adapter as BaseAdapter<T>?)?.setItems(emptyList())
    }
}