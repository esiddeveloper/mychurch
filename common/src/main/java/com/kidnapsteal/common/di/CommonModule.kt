package com.kidnapsteal.common.di

import android.app.Application
import android.content.Context
import com.kidnapsteal.common.di.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module

@Module
abstract class CommonModule {

    @Binds
    @ApplicationContext
    abstract fun applicationContext(app: Application): Context

}