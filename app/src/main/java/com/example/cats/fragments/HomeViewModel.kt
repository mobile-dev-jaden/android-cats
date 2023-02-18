package com.example.cats.fragments

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.cats.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.hicare.practice.sample.data.CatBreedsDataSource
import net.hicare.practice.sample.data.models.response.CatBreed
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
   private val breedsDataSource: CatBreedsDataSource
): BaseViewModel() {

   init {

      viewModelScope.launch {
         getBreeds().forEach {
            Log.d("TAG", "${it.id} == ${it.name}")
         }
      }
   }

   suspend fun getBreeds(): List<CatBreed> =
      breedsDataSource.getCatBreeds()

}