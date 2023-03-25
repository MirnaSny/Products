package com.task.products.data.di

import com.task.products.data.api.ProductsApi
import com.task.products.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(productsApi: ProductsApi):Repository{
        return Repository(productsApi)
    }
}