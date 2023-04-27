package com.task.products.presentation.features.product
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.products.domain.model.products.ProductsResponseModel
import com.task.products.domain.usecase.details.GetProductByIdUseCase
import com.task.products.domain.usecase.products.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsSortedByNameUseCase: GetProductsUseCase
) : ViewModel() {

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

                _productsStateFlow.emit(getProductsSortedByNameUseCase())

            } catch (e: Exception) {
                _productsErrorStateFlow.emit(e)
            }
            _productsLoadingStateFlow.emit(false)
        }
    }
}