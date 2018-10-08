package com.kidnapsteal.mychruch.di

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Scope

@Module
abstract class AppModule {
    @Binds
    abstract fun bindContext(app: Application): Context

}