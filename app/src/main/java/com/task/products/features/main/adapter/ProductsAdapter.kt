package com.task.products.features.main.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.products.data.model.ProductsResponseModel
import com.task.products.databinding.RowProductsBinding
import com.task.products.features.product.details.ProductDetailsFragment

class ProductsAdapter(
    private val list: List<ProductsResponseModel>,
    private val onClickItem: (model: ProductsResponseModel) -> Unit
) :
    RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {


    inner class ProductViewHolder(val binding: RowProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductsResponseModel) {
            binding.product = product
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = RowProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            onClickItem(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}







