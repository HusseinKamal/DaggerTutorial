package com.hussein.daggar.retrofit

import com.hussein.daggar.models.Product
import com.hussein.daggar.models.ProductX
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("products")
    suspend fun getProducts(): Response<Product>
}