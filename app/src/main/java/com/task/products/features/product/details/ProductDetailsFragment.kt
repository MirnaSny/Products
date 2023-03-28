package com.task.products.features.product.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.task.products.databinding.ActivityMainBinding
import com.task.products.databinding.ActivityProductDetailsBinding
import com.task.products.features.main.MainViewModel
import com.task.products.features.main.adapter.ViewPagerAdapter

class ProductDetailsFragment : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityProductDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)





    }

}