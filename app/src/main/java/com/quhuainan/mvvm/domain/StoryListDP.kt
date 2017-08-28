package com.quhuainan.mvvm.domain

import com.quhuainan.mvvm.di.component.DaggerResponseComponent
import com.quhuainan.mvvm.di.module.ResponseModule
import com.quhuainan.mvvm.response.bean.News
import com.quhuainan.mvvm.response.http.StoryListService
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by qhn
 * on 2017/7/22.
 */
class StoryListDP @Inject constructor() {
    init {
        DaggerResponseComponent.builder().responseModule(ResponseModule()).build().inject(this)
    }

    lateinit var mService: StoryListService
        @Inject set

    fun getStoryListData(subscriber: Subscriber<News>) {
        mService.getStoryListObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber)
    }


}