package com.example.si_assignment

import android.app.Application
import com.example.si_assignment.di.appModule
import com.example.si_assignment.di.repoModule
import com.example.si_assignment.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}