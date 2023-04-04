package com.task.products.features.product.details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.task.products.data.model.ProductsResponseModel
import com.task.products.databinding.ActivityMainBinding
import com.task.products.databinding.ActivityProductDetailsBinding
import com.task.products.features.main.MainViewModel
import com.task.products.features.main.adapter.ViewPagerAdapter

class ProductDetailsFragment : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val image = intent.getStringArrayListExtra("image")
        val description = intent.getStringExtra("description")
        val price = intent.getStringExtra("price")


        binding.apply {
            textViewNameProduct.text = name
            textViewPriceProduct.text = price
            textViewDescriptionProduct.text = description
        }
    }

}