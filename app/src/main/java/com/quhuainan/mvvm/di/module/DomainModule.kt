package com.quhuainan.mvvm.di.module

import com.quhuainan.mvvm.domain.StoryListDP
import dagger.Module
import dagger.Provides

/**
 * Created by qhn
 * on 2017/8/28.
 */
@Module
class DomainModule {
    @Provides
    fun provideStoryListDP(): StoryListDP {
        return StoryListDP()
    }
}