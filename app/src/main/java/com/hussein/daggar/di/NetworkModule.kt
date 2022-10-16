package com.hussein.daggar.di

import com.hussein.daggar.retrofit.RetrofitAPI
import com.hussein.daggar.utils.Constant
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitAPI(retrofit: Retrofit):RetrofitAPI
    {
        return retrofit.create(RetrofitAPI::class.java)
    }
}