package com.quhuainan.mvvm.ui.widget.recyclerview

/**
 * Created by qhn
 * on 2017/8/15.
 */
interface ItemClickListener<T> {
    fun clickItem(position: Int, data: T)
}