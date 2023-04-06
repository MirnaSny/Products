package com.task.products.domain.model


data class ProductsResponseModel(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Float,
    val rating: Float,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val image: List<String>,
    val active: Boolean,

    //local var
    var selected:Boolean=false
) {
    fun getFullPrice() = "{$price} $"
}