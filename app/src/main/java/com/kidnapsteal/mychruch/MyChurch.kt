package com.kidnapsteal.mychruch

import android.app.Activity
import com.kidnapsteal.common.di.DaggerCommonComponent
import com.kidnapsteal.mychruch.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

open class MyChurch : DaggerApplication(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val commitComponent = DaggerCommonComponent.builder().application(this).build()
        return DaggerAppComponent.builder().application(this).commitComponent(commitComponent).build()
    }

}