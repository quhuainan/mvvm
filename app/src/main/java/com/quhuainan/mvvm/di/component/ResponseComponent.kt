package com.quhuainan.mvvm.di.component

import com.quhuainan.mvvm.di.module.ResponseModule
import com.quhuainan.mvvm.domain.StoryListDP
import com.quhuainan.mvvm.response.http.StoryListService
import dagger.Component

/**
 * Created by qhn
 * on 2017/8/28.
 */
@Component(modules = arrayOf(ResponseModule::class))
interface ResponseComponent {
    fun storyListService(): StoryListService
    fun inject(storyListDP: StoryListDP)
}