package com.task.products.domain.usecase.products

import com.task.products.domain.model.products.ProductsResponseModel
import com.task.products.domain.repo.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val repository: ProductRepository) {
    suspend operator fun invoke(): List<ProductsResponseModel> {
        return repository.getProducts()
    }
}