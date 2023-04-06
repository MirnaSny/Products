package com.task.products.data.api

import com.task.products.domain.model.ProductsResponseModel
import com.task.products.domain.model.WrapperProductsResponseModel
import retrofit2.http.GET

interface ProductsApi{

    @GET("/products?")
   suspend fun getProducts(): WrapperProductsResponseModel

}