package com.quhuainan.mvvm.di.component

import com.quhuainan.mvvm.di.module.DomainModule
import com.quhuainan.mvvm.ui.main.MainViewModel
import dagger.Component

/**
 * Created by qhn
 * on 2017/8/28.
 */

@Component(modules = arrayOf(DomainModule::class))
interface DomainComponent {
    fun inject(viewModel: MainViewModel)
}