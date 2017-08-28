package com.quhuainan.mvvm.binding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.quhuainan.mvvm.R
import com.youth.banner.Banner

/**
 * Created by qhn
 * on 2017/8/28.
 */
@BindingAdapter("url")
fun setLoadUrl(imageView: ImageView, url: List<String>?) {
    Glide.with(imageView.context).load(url?.get(0)).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageView)
}

@BindingAdapter("bannerUrls", "bannerTitles")
fun setBannerValues(banner: Banner, bannerUrls: List<String>?, bannerTitles: List<String>?) {
    banner.setBannerTitles(bannerTitles?: listOf())
    banner.setImages(bannerUrls?: mutableListOf<String>())
    banner.start()
}

