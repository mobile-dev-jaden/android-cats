package net.hicare.practice.sample.data

import android.util.Log
import kotlinx.coroutines.*
import net.hicare.practice.sample.data.apis.CatBreedApi
import net.hicare.practice.sample.data.models.response.CatBreed
import retrofit2.create
import retrofit2.http.GET

class CatBreedsDataSource: BaseService() {
    companion object {
        const val TAG = "CatBreedsDataSource"
    }

    private val service =
        getRetrofit().create(CatBreedApi::class.java)

    suspend fun getCatBreeds(): List<CatBreed> = try {
        service.getCatBreeds()
    } catch (e: Exception) {
        Log.e(TAG, "${e.message}")
        emptyList()
    }

}