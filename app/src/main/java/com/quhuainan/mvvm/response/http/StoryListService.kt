package com.quhuainan.mvvm.response.http

import com.example.admin.weatherapp.data.UrlConstant
import com.quhuainan.mvvm.response.bean.News
import retrofit2.http.GET
import rx.Observable

/**
 * Created by qhn
 * on 2017/8/28.
 */
interface StoryListService {
    @GET(UrlConstant.v4Version + "news/latest")
    fun getStoryListObservable(): Observable<News>
}