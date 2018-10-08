package com.kidnapsteal.mychruch.di

import android.app.Application
import android.content.Context
import com.kidnapsteal.common.di.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    @ApplicationContext
    abstract fun bindContext(app: Application): Context

}