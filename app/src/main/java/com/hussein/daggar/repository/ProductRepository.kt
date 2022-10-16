package com.hussein.daggar.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hussein.daggar.models.Product
import com.hussein.daggar.retrofit.RetrofitAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val retrofitAPI: RetrofitAPI) {
    private val _products=MutableLiveData<Product>()
    val products:LiveData<Product>
    get() = _products

    suspend fun getProducts()
    {
        val result=retrofitAPI.getProducts()
        if(result.isSuccessful && result.body()!=null)
        {
            _products.postValue(result.body())
        }
    }
}