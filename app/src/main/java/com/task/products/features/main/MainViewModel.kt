package com.task.products.features.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.products.domain.model.ProductsResponseModel
import com.task.products.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _productsStateFlow: MutableStateFlow<List<ProductsResponseModel>> =
        MutableStateFlow(emptyList())
    val productStateFlow = _productsStateFlow.asStateFlow()

    private val _productsLoadingStateFlow: MutableStateFlow<Boolean> =
        MutableStateFlow(true)
    val productsLoadingStateFlow = _productsLoadingStateFlow.asStateFlow()

    private val _productsErrorStateFlow: MutableStateFlow<Exception?> =
        MutableStateFlow(null)
    val productsErrorStateFlow = _productsErrorStateFlow.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            _productsLoadingStateFlow.emit(true)
            try {
                _productsStateFlow.emit(repository.getProducts())

            } catch (e: Exception) {
                _productsErrorStateFlow.emit(e)
            }
            _productsLoadingStateFlow.emit(false)
        }
    }
}