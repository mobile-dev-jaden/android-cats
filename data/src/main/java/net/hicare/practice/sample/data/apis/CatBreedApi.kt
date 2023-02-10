package net.hicare.practice.sample.data.apis

import net.hicare.practice.sample.data.models.response.CatBreed
import retrofit2.http.GET

interface CatBreedApi {
    @GET("breeds/")
    suspend fun getCatBreeds(): List<CatBreed>
}
