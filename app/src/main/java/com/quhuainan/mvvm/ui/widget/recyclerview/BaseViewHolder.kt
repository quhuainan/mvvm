package com.quhuainan.mvvm.ui.widget.recyclerview

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by qhn
 * on 2017/8/14.
 */
class BaseViewHolder<T : ViewDataBinding>(var binding: T) : RecyclerView.ViewHolder(binding.root)

