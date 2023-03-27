package com.task.products.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.products.data.model.ProductsResponseModel
import com.task.products.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val productsSuccessLiveData: MutableLiveData<List<ProductsResponseModel>> = MutableLiveData()
    val productsErrorLiveData: MutableLiveData<Exception> = MutableLiveData()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            try {
                val response = repository.getProducts()
                productsSuccessLiveData.postValue(response)
            } catch (e: Exception) {
                productsErrorLiveData.postValue(e)
            }
        }
    }
}