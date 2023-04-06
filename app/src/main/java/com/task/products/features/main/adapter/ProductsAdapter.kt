package com.task.products.features.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.products.domain.model.ProductsResponseModel
import com.task.products.databinding.RowProductsBinding

class ProductsAdapter(private val list: List<ProductsResponseModel>) :
    RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    var indexLastSelected = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = RowProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val model = list[position]
        holder.bind(model, position)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    inner class ProductViewHolder(private val binding: RowProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ProductsResponseModel, position: Int) {
            binding.product = model

            binding.linearLayout.setOnClickListener {
                if (position != indexLastSelected) {

                    //if not default
                    //notify last item
                    if (indexLastSelected != -1) {
                        list[indexLastSelected].selected = false
                        notifyItemChanged(indexLastSelected)
                    }
                    //notify new item
                    indexLastSelected = position
                    list[position].selected=true
                    notifyItemChanged(position)

                }
            }

        }

    }
}







