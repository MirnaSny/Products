package com.task.products.domain.model.products

data class ProductWrapper<T>(
    val limit: Int,
    val products: T,
    val skip: Int,
    val total: Int
)