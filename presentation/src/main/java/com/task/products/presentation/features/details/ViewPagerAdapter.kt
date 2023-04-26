package com.task.products.presentation.features.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.products.presentation.databinding.ImagesBinding

class ViewPagerAdapter(var imageList: List<String>) :
    RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    class PagerViewHolder(val binding: ImagesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val binding = ImagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        val image = imageList[position]
        holder.binding.image = image

    }
}
