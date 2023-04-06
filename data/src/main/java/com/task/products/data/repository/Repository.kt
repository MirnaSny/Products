package com.task.products.data.repository

import com.task.products.data.api.ProductsApi
import com.task.products.domain.model.ProductsResponseModel
import javax.inject.Inject

class Repository @Inject constructor(private val productsApi: ProductsApi) {

    suspend fun getProducts(): List<ProductsResponseModel> {
        return productsApi.getProducts().products
    }
}