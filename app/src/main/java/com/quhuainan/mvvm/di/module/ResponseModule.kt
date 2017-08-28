package com.quhuainan.mvvm.di.module

import com.example.admin.weatherapp.data.UrlConstant
import com.quhuainan.mvvm.response.http.RetrofitFactory
import com.quhuainan.mvvm.response.http.StoryListService
import dagger.Module
import dagger.Provides

/**
 * Created by qhn
 * on 2017/8/28.
 */
@Module
class ResponseModule {
    @Provides
    fun provideStoryListService(): StoryListService {
        return RetrofitFactory.createService(StoryListService::class.java, UrlConstant.sRootUri)
    }
}