package net.hicare.practice.sample.data

import com.facebook.stetho.okhttp3.StethoInterceptor
import net.hicare.practice.sample.data.interceptor.BaseHeaderInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseService {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(stethoInterceptor)
            .client(baseHeaderInterceptor)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Const.BASE_URL)
            .build()
    }

    private val baseHeaderInterceptor = OkHttpClient.Builder()
        .addInterceptor(BaseHeaderInterceptor())
        .build()

    private val stethoInterceptor = OkHttpClient.Builder()
        .addInterceptor(StethoInterceptor())
        .build()
}

