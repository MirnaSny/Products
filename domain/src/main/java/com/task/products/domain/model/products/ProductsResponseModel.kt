package com.task.products.domain.model.products

import com.google.gson.annotations.SerializedName


data class ProductsResponseModel(

    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("price")
    val price: Int,

    @SerializedName("discountPercentage")
    val discountPercentage: Float,

    @SerializedName("rating")
    val rating: Float,

    @SerializedName("stock")
    val stock: Int,

    @SerializedName("brand")
    val brand: String,

    @SerializedName("category")
    val category: String,

    @SerializedName("thumbnail")
    val thumbnail: String,

    @SerializedName("image")
    val image: List<String>,

    @SerializedName("active")
    val active: Boolean,

    //local var
    var selected:Boolean=false
) {
    fun getFullPrice() = "{$price} $"

}