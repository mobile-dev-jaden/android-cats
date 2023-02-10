package com.example.cats.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ServiceScoped
import dagger.hilt.android.scopes.ViewModelScoped
import net.hicare.practice.sample.data.CatBreedsDataSource

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModules {

    @Provides
    @ViewModelScoped
    fun providesCatBreedsDataSource(
    ): CatBreedsDataSource = CatBreedsDataSource()

}