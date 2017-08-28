package com.quhuainan.mvvm.di.component;

import android.content.Context;


import com.quhuainan.mvvm.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by qhn
 * on 2016/10/27 0027.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context getApplication();

}