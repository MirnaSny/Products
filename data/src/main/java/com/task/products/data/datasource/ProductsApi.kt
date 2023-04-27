package com.task.products.data.datasource

import com.task.products.domain.model.products.ProductWrapper
import com.task.products.domain.model.products.ProductsResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsApi{

    @GET("/products")
   suspend fun getProducts(): ProductWrapper<List<ProductsResponseModel>>

    @GET("/product/{id}")
    suspend fun getProductsById(@Path("id")id:String) : ProductsResponseModel


}