package com.task.products.presentation.features.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.task.products.domain.model.products.ProductsResponseModel
import com.task.products.presentation.R
import com.task.products.presentation.databinding.FragmentProductsBinding
import com.task.products.presentation.features.product.adapter.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: FragmentProductsBinding

    private val viewModel: ProductsViewModel by viewModels()

    private lateinit var adapter: ProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProductsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserver()
        initAdapter()
        initListener()
    }

    private fun initAdapter() {
        adapter = ProductsAdapter(::onClickItem)
        binding.recyclerViewProduct.adapter = adapter
    }

    private fun initListener() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.getProducts()
            lifecycleScope.launch {
                delay(3000)
                binding.swipeRefresh.isRefreshing = false
            }
        }
    }


    private fun initObserver() {
        lifecycleScope.launch {
            viewModel.productStateFlow.collect(::onSuccessProducts)
        }

        lifecycleScope.launch {
            viewModel.productsLoadingStateFlow.collect { show ->
                binding.progressCircular.isVisible = show
            }
        }

        lifecycleScope.launch {
            viewModel.productsErrorStateFlow.collect { response ->
                if (response != null) {
                    Log.d("TAG00", response.toString())
                }
            }
        }
    }

    private fun onSuccessProducts(response: List<ProductsResponseModel>?) {
        if (response?.isNotEmpty() == true) adapter.submitList(response)
    }


    private fun onClickItem(id: String) {
        findNavController().navigate(R.id.detailsProductFragment, bundleOf("id" to id))

    }
}