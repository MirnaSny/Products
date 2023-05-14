package com.task.products.domain.model.products


data class ProductsResponseModel(
    val id: String,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Double,
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