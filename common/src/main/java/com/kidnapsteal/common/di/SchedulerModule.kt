package com.kidnapsteal.common.di

import com.kidnapsteal.common.RxSchedulers
import com.kidnapsteal.common.RxSchedulersImpl
import dagger.Binds
import dagger.Module

@Module
abstract class SchedulerModule {
    @Binds
    abstract fun bindRxScheduler(rxSchedulersImpl: RxSchedulersImpl): RxSchedulers
}