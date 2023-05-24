package com.task.products.presentation.features.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.products.domain.model.products.ProductsResponseModel
import com.task.products.domain.usecase.details.GetProductByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getProductsByIdUseCase: GetProductByIdUseCase,
    state: SavedStateHandle
) : ViewModel(){

    private val _detailsStateFlow: MutableStateFlow<ProductsResponseModel?> =
        MutableStateFlow(null)
    val detailsStateFlow = _detailsStateFlow.asStateFlow()

    private val _detailsLoadingStateFlow: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    val detailsLoadingStateFlow = _detailsLoadingStateFlow.asStateFlow()

    private val _detailsErrorStateFlow: MutableStateFlow<Exception?> =
        MutableStateFlow(null)
    val detailsErrorStateFlow = _detailsErrorStateFlow.asStateFlow()

    private val savedStateHandle=state
    init {
        details()
    }

     fun details() {
         val id = savedStateHandle.get<String>("id")?:"-1"
        viewModelScope.launch {
            _detailsLoadingStateFlow.emit(true)
            try {
                _detailsStateFlow.emit(getProductsByIdUseCase(id))
            } catch (e: Exception) {
                _detailsErrorStateFlow.emit(e)
            }
            _detailsLoadingStateFlow.emit(false)
        }
    }
}