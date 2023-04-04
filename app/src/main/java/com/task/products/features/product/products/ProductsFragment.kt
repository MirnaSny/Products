package com.task.products.features.product.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.task.products.databinding.FragmentProductsBinding
import com.task.products.features.fragments.ProductsFragments
import com.task.products.features.main.MainViewModel

class ProductsFragment : Fragment() {

private lateinit var binding :FragmentProductsBinding

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

        viewModel.productsSuccessLiveData.observe(viewLifecycleOwner){response ->
            Toast.makeText(requireContext(),response.toString(),Toast.LENGTH_LONG).show()
        }
    }
}