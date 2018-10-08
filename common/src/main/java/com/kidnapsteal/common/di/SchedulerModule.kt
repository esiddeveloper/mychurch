package com.kidnapsteal.common.di

import com.kidnapsteal.common.RxSchedulers
import com.kidnapsteal.common.RxSchedulersImpl
import com.kidnapsteal.common.di.scope.ApplicationScope
import dagger.Binds
import dagger.Module

@Module
abstract class SchedulerModule {
    @Binds
    @ApplicationScope
    abstract fun bindRxScheduler(rxSchedulersImpl: RxSchedulersImpl): RxSchedulers
}