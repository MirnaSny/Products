package com.task.products.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.viewpager.widget.ViewPager
import com.task.products.ProductDetails
import com.task.products.R
import com.task.products.data.model.ProductsResponseModel
import com.task.products.databinding.ActivityMainBinding
import com.task.products.ui.main.adapter.ProductsAdapter
import com.task.products.ui.main.adapter.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

//    private lateinit var viewPagerAdapter:ViewPagerAdapter
//    val ViewPager:ViewPager=findViewById(R.id.viewpager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserver()
    }

    private fun initObserver() {
        viewModel.productsSuccessLiveData.observe(this) { response ->
            Toast.makeText(this,response.get(0).brand,Toast.LENGTH_LONG).show()
            binding.recyclerViewProduct.adapter = ProductsAdapter(response){

            }
//            viewPagerAdapter.
        }

        viewModel.productsErrorLiveData.observe(this) { e ->
            Toast.makeText(this, "error=${e.localizedMessage}", Toast.LENGTH_LONG).show()

        }
    }

    private fun onClickItem(model :ProductsResponseModel){
        val intent=Intent(this,ProductDetails::class.java)
        intent.putExtra("name",model.title)
        val list = ArrayList<String>()
        list.addAll(model.image)
        intent.putStringArrayListExtra("image",list)
        intent.putExtra("description",model.description)
        intent.putExtra("price",model.price.toString())
        startActivity(intent)


        val image= listOf<String>()
//        ViewPager.adapter=ViewPagerAdapter(image)

    }

}
