package com.task.products.domain.repo

import com.task.products.domain.model.products.ProductsResponseModel

interface ProductRepository {
    suspend fun getProducts(): List<ProductsResponseModel>
    suspend fun getProductsById(id: String): ProductsResponseModel

}