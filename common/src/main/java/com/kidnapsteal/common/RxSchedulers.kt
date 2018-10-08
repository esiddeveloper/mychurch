    package com.kidnapsteal.common

import com.kidnapsteal.common.di.scope.ApplicationScope
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface RxSchedulers {
    fun io(): Scheduler
    fun ui(): Scheduler
    fun newThread(): Scheduler
    fun computation(): Scheduler
}

@ApplicationScope
class RxSchedulersImpl @Inject constructor() : RxSchedulers {
    override fun io(): Scheduler = Schedulers.io()

    override fun ui(): Scheduler = AndroidSchedulers.mainThread()

    override fun newThread(): Scheduler = Schedulers.newThread()

    override fun computation(): Scheduler = Schedulers.computation()

}