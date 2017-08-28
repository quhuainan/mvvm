package com.quhuainan.mvvm.ui.widget.recyclerview

import android.databinding.ViewDataBinding

/**
 * Created by qhn
 * on 2017/8/15.
 */
interface BindEventHandler<in T, E : ViewDataBinding> {
    fun bindEvent(holder: BaseViewHolder<E>, data: T)
}