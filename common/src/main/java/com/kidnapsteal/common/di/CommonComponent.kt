package com.kidnapsteal.common.di

import android.app.Application
import com.kidnapsteal.common.RxSchedulers
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import okhttp3.OkHttpClient

@Component(modules = [
    CommonModule::class,
    NetworkModule::class,
    SchedulerModule::class,
    AndroidSupportInjectionModule::class])
interface CommonComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): CommonComponent
    }

    fun okhttpBuilder(): OkHttpClient.Builder
    fun rxScheduler(): RxSchedulers

}