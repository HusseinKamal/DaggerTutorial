package com.hussein.daggar

import android.app.Application
import com.hussein.daggar.di.ApplicationComponent
import com.hussein.daggar.di.DaggerApplicationComponent

class App :Application() {
    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component= DaggerApplicationComponent.builder().build()
    }
}