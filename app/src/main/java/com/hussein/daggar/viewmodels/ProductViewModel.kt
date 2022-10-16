package com.hussein.daggar.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hussein.daggar.models.Product
import com.hussein.daggar.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(val repository: ProductRepository) :ViewModel(){
    val productsLiveData:LiveData<Product>
    get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}