package com.task.products.domain.usecase.details

import com.task.products.domain.model.products.ProductsResponseModel
import com.task.products.domain.repo.ProductRepository
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(private val repository: ProductRepository) {
    suspend operator fun invoke (id:String): ProductsResponseModel {
        return repository.getProductsById(id)
    }
}