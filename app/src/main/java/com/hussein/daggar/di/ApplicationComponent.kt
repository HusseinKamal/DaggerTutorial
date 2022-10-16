package com.hussein.daggar.di

import com.hussein.daggar.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun injtect(mainActivity: MainActivity)
}