package com.task.products.presentation.features.product.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.task.products.domain.model.products.ProductsResponseModel
import com.task.products.presentation.databinding.RowProductsBinding

class ProductsAdapter(
    private val onClickItem: (id: String) -> Unit
) : ListAdapter<ProductsResponseModel, ProductsAdapter.ProductViewHolder>(DiffCallback) {

    var indexLastSelected = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = RowProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model, position)
    }


    inner class ProductViewHolder(private val binding: RowProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ProductsResponseModel, position: Int) {
            binding.product = model


            itemView.setOnClickListener {
                onClickItem(model.id)

                if (position != indexLastSelected) {

                    //if not default
                    //notify last item
                    if (indexLastSelected != -1) {
                        getItem(indexLastSelected).selected = false
                        notifyItemChanged(indexLastSelected)
                    }
                    //notify new item
                    indexLastSelected = position
                    getItem(position).selected = true
                    notifyItemChanged(position)
                }

            }

        }

    }

    private object DiffCallback : DiffUtil.ItemCallback<ProductsResponseModel>() {

        override fun areItemsTheSame(
            oldItem: ProductsResponseModel,
            newItem: ProductsResponseModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProductsResponseModel,
            newItem: ProductsResponseModel
        ): Boolean {
            return oldItem == newItem
        }

    }


}







