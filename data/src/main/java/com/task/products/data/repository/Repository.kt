package com.task.products.data.repository

import com.task.products.data.api.ProductsApi
import com.task.products.data.model.ProductsResponseModel

class Repository (private val productsApi: ProductsApi){

suspend fun getProducts():List<ProductsResponseModel> {
    return productsApi.getProducts().products
}
}