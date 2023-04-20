package com.task.products.data.repository

import com.task.products.data.datasource.ProductsApi
import com.task.products.domain.model.products.ProductsResponseModel
import com.task.products.domain.repo.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val productsApi: ProductsApi):ProductRepository {

   override suspend fun getProducts(): List<ProductsResponseModel> {
        return productsApi.getProducts()
    }

    override suspend fun getProductsById(id: String): ProductsResponseModel {
        return productsApi.getProductsById(id)
    }
}