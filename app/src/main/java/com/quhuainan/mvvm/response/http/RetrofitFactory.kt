package com.quhuainan.mvvm.response.http

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by qhn
 * on 2017/7/22.
 */
object RetrofitFactory {

    fun <T> createService(service: Class<T>, url: String): T {
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(url)
                .client(buildOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        return retrofit.create(service)
    }

    private fun buildOkHttpClient(): OkHttpClient? {
        val TAG: String = "RetrofitFactory"
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
        builder.addInterceptor { chain ->
            val request: Request = chain.request()
            val t1 = System.nanoTime()
            Log.i(TAG, String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()))
            val response: Response = chain.proceed(request)
            val t2 = System.nanoTime()
            Log.i(TAG, String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6, response.headers()))
            return@addInterceptor response
        }
        return builder.build()
    }

}