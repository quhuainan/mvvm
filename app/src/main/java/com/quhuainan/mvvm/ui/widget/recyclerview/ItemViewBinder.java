package com.quhuainan.mvvm.ui.widget.recyclerview;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.quhuainan.mvvm.BR;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by qhn
 * on 2017/8/15.
 */

public class ItemViewBinder<T, E extends ViewDataBinding,R> extends ItemViewProvider<T, BaseViewHolder<E>> {
    public int layoutID;
    private ItemClickListener<T> listener;
    private BindEventHandler<T, E> eventListener;
    private R viewModel;
    public ItemViewBinder(int layoutID) {
        this.layoutID = layoutID;
    }
    public R getViewModel() {
        return viewModel;
    }

    public void setViewModel(R viewModel) {
        this.viewModel = viewModel;
    }

    public ItemClickListener<T> getListener() {
        return listener;
    }

    public void setListener(ItemClickListener<T> listener) {
        this.listener = listener;
    }

    public BindEventHandler<T, E> getEventListener() {
        return eventListener;
    }

    public void setEventListener(BindEventHandler<T, E> eventListener) {
        this.eventListener = eventListener;
    }

    @NonNull
    @Override
    protected BaseViewHolder<E> onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        E mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutID, parent, false);
        return new BaseViewHolder<>(mBinding);
    }

    @Override
    protected void onBindViewHolder(@NonNull final BaseViewHolder<E> holder, @NonNull final T data) {
        holder.getBinding().setVariable(BR.item, data);
        if (viewModel!=null) {
            holder.getBinding().setVariable(BR.viewModel,viewModel);
        }
        holder.getBinding().executePendingBindings();
        if (listener!=null) {
            holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.clickItem(holder.getAdapterPosition(), data);
                }
            });
        }

        if (eventListener != null) {
            eventListener.bindEvent(holder, data);
        }
    }
}
