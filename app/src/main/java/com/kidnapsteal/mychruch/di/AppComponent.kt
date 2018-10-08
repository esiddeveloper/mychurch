package com.kidnapsteal.mychruch.di

import android.app.Application
import com.kidnapsteal.mychruch.MyChurch
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
        modules = [
            AppModule::class,
            AndroidSupportInjectionModule::class]
)
interface AppComponent : AndroidInjector<MyChurch> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}