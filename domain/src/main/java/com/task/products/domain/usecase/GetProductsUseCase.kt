package com.task.products.domain.usecase

import com.task.products.data.repository.Repository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val repository: Repository) {
}