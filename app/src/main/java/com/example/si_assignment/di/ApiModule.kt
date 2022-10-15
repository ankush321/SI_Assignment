package com.example.si_assignment.di

import android.content.Context
import androidx.databinding.ktx.BuildConfig
import com.example.si_assignment.data.api.ApiHelper
import com.example.si_assignment.data.api.ApiService
import com.example.si_assignment.data.api.ApiServiceImpl
import com.example.si_assignment.util.NetworkHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val appModule = module {
    factory { provideMatchApiService(retrofit = get()) }
    single { provideOkHttpClient() }
    single { provideRetrofit(okHttpClient =  get()) }
    single { provideNetworkHelper(androidContext()) }

    single<ApiHelper> {
        return@single ApiServiceImpl(get())
    }
}

private fun provideNetworkHelper(context: Context) = NetworkHelper(context)

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://demo.sportz.io")
        .client(okHttpClient)
        .build()

private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
} else OkHttpClient
    .Builder()
    .build()

fun provideMatchApiService(retrofit: Retrofit):ApiService = retrofit.create(ApiService::class.java)