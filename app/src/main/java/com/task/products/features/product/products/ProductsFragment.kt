package com.task.products.features.product.products

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.task.products.databinding.FragmentProductsBinding
import com.task.products.features.main.MainViewModel
import com.task.products.features.main.adapter.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsFragment : Fragment() {

    private lateinit var binding: FragmentProductsBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProductsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch() {
            viewModel.productStateFlow.collect { response ->
                if (response.isNotEmpty())
                    binding.recyclerViewProduct.adapter = ProductsAdapter(response)
            }
        }

        lifecycleScope.launch() {
            viewModel.productsLoadingStateFlow.collect { show ->
                binding.progressCircular.isVisible = show
            }
        }

        lifecycleScope.launch() {
            viewModel.productsErrorStateFlow.collect { response ->
                if (response != null) {
                    Log.d("TAG", response.toString())
                }
            }
        }
    }
}
