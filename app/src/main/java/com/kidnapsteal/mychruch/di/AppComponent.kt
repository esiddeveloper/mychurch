package com.kidnapsteal.mychruch.di

import android.app.Application
import com.kidnapsteal.common.di.CommonComponent
import com.kidnapsteal.common.di.NetworkModule
import com.kidnapsteal.common.di.SchedulerModule
import com.kidnapsteal.mychruch.MyChurch
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
        modules = [
            AppModule::class,
            NetworkModule::class,
            SchedulerModule::class,
            AndroidSupportInjectionModule::class],
        dependencies = [CommonComponent::class]
)
interface AppComponent : AndroidInjector<MyChurch> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun commitComponent(component: CommonComponent): Builder

        fun build(): AppComponent
    }
}