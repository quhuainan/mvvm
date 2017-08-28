package com.quhuainan.mvvm.ui.main

import android.databinding.ObservableField
import android.util.Log
import com.quhuainan.mvvm.di.component.DaggerDomainComponent
import com.quhuainan.mvvm.di.module.DomainModule
import com.quhuainan.mvvm.domain.StoryListDP
import com.quhuainan.mvvm.response.bean.News
import com.quhuainan.mvvm.response.bean.Story
import rx.Subscriber
import javax.inject.Inject

/**
 * Created by qhn
 * on 2017/8/28.
 */
class MainViewModel @Inject constructor() {

    init {
        DaggerDomainComponent.builder().domainModule(DomainModule()).build().inject(this)

    }
    lateinit var storyListDP: StoryListDP
        @Inject set

    val storyListObs = ObservableField<List<Story>>()
    val bannerUrlsObs = ObservableField<List<String>>()
    val bannerTitleObs = ObservableField<List<String>>()
    fun handleArticleList() {
        // model.toString()
        storyListDP.getStoryListData(object : Subscriber<News>() {
            override fun onCompleted() {

            }

            override fun onNext(t: News?) {
                storyListObs.set(t?.let { t.stories } ?: listOf())
                bannerTitleObs.set(t?.top_stories?.map { it.title }?.toList())
                bannerUrlsObs.set(t?.top_stories?.map { it.image }?.toList())
            }

            override fun onError(e: Throwable?) {
                Log.d("aaa", e.toString())
            }
        })
    }
}