package com.example.picexplorer.data.di

import com.example.picexplorer.data.repository.ImagesRepositoryImpl
import com.example.picexplorer.data.repository.UserRepositoryImpl
import com.example.picexplorer.data.source.remote.ApiService
import com.example.picexplorer.domain.repository.ImagesRepository
import com.example.picexplorer.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(api: ApiService): UserRepository {
        return UserRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideImageRepository(api: ApiService): ImagesRepository {
        return ImagesRepositoryImpl(api)
    }
}
