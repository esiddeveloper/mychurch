package com.kidnapsteal.common.di

import android.content.Context
import android.os.Build
import com.google.gson.Gson
import com.kidnapsteal.common.RxSchedulers
import com.kidnapsteal.common.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.internal.Version
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Named


@Module
class NetworkModule {

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun provideOkHttpInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideGsonConverter(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun provideResponseCache(@ApplicationContext context: Context): Cache {
        val dir = File(context.cacheDir, "cache-response")
        val maxSize = 1L * 1024 * 1024 * 5 //5MB
        return Cache(dir, maxSize)
    }

    @Provides
    fun provideOkHttpBuilder(httpLoggingInterceptor: HttpLoggingInterceptor,
                             @Named(APP_USER_AGENT) userAgent: String,
                             cache: Cache): OkHttpClient.Builder {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor {
                    it.proceed(it.request().newBuilder().addHeader("User-Agent", userAgent).build())
                }.cache(cache)
    }

    @Provides
    fun provideRxJavaAdapter(rxSchedulers: RxSchedulers): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createWithScheduler(rxSchedulers.io())
    }

    @Provides
    @Named(APP_USER_AGENT)
    fun provideUserAgent(@ApplicationContext context: Context): String {
        val appName = context.applicationInfo.packageName
        val appInfo = context.packageManager.getApplicationInfo(appName, 0)
        val packInfo = context.packageManager.getPackageInfo(context.packageName, 0);
        val appDesc = context.packageManager.getApplicationLabel(appInfo).toString()

        val uaAppDesc = "$appDesc/${packInfo.versionName}-${packInfo.longVersionCode} "
        val uaDeviceDesc = "(${Build.MANUFACTURER}; Android ${Build.VERSION.RELEASE}; ${Build.MODEL} Build/${Build.ID}) "
        val uaOkHttp = Version.userAgent()

        return uaAppDesc + uaDeviceDesc + uaOkHttp
    }

    private companion object {
        const val APP_USER_AGENT = "app_user_agent"
    }

}