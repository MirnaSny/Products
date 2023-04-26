package com.task.products.data.di

import com.task.products.data.datasource.ProductsApi
import com.task.products.data.repository.ProductRepositoryImpl
import com.task.products.domain.repo.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepositoryProducts(ProductsApi: ProductsApi):ProductRepository{
        return ProductRepositoryImpl(ProductsApi)
    }
}