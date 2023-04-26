package com.task.products.presentation.features.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.task.products.presentation.databinding.FragmentProductDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailsBinding
    private val viewModel: DetailsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }


    private fun initObserver() {
        lifecycleScope.launch {
            viewModel.detailsStateFlow.collect { response ->
                if (response != null)
                    binding.details = response
            }
        }

        lifecycleScope.launch {
            viewModel.detailsLoadingStateFlow.collect { show ->
                binding.progressCircular.isVisible = show
            }
        }

        lifecycleScope.launch {
            viewModel.detailsErrorStateFlow.collect { response ->
                if (response != null) {
                    Log.d("TAG00", response.toString())
                }
            }
        }
    }
}
