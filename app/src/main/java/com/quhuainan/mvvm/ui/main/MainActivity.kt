package com.quhuainan.mvvm.ui.main

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.quhuainan.mvvm.R
import com.quhuainan.mvvm.databinding.ActivityMainBinding
import com.quhuainan.mvvm.databinding.ItemNewsListBinding
import com.quhuainan.mvvm.response.bean.Story
import com.quhuainan.mvvm.ui.widget.recyclerview.ItemViewBinder
import com.youth.banner.BannerConfig
import com.youth.banner.loader.ImageLoader
import me.drakeet.multitype.Items
import me.drakeet.multitype.MultiTypeAdapter

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel: MainViewModel
    // var mModel: Model=Mo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = MainViewModel()
        mBinding.item = mViewModel
        setSupportActionBar(mBinding.appBar.toolbar)

        //banner
        mBinding.appBar.banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)
        mBinding.appBar.banner.setImageLoader(object : ImageLoader() {
            override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
                Glide.with(context).load(path as String).placeholder(R.mipmap.ic_launcher).into(imageView)
            }
        })
        mBinding.appBar.banner.start()

        //列表
        mBinding.appBar.rvArticleList.layoutManager = LinearLayoutManager(this)
        val articleList = ItemViewBinder<Story, ItemNewsListBinding, Object>(R.layout.item_news_list)
        val adapter = MultiTypeAdapter()
        val items = Items()
        adapter.register(Story::class.java, articleList)
        adapter.setItems(items)
        mBinding.appBar.rvArticleList.adapter = adapter
        mViewModel.handleArticleList()
        mViewModel.storyListObs.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(p0: Observable?, p1: Int) {
                items.addAll(mViewModel.storyListObs.get())
                adapter.notifyDataSetChanged()
            }
        })
    }

}
