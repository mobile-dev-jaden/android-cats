package com.example.cats.fragments

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.cats.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.hicare.practice.sample.data.CatBreedsDataSource
import net.hicare.practice.sample.data.models.response.CatBreed
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val catBreedsDataSource: CatBreedsDataSource
): BaseViewModel() {

    val catBreeds = mutableStateOf<List<CatBreed>>(emptyList())

    init {
        viewModelScope.launch {
            catBreeds.value = getCatBreeds()

        }
    }

    private suspend fun getCatBreeds(): List<CatBreed> =
        catBreedsDataSource.getCatBreeds()

}