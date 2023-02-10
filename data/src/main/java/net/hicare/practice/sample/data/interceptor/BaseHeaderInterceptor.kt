package net.hicare.practice.sample.data.interceptor

import net.hicare.practice.sample.data.Const
import okhttp3.Interceptor
import okhttp3.Response

class BaseHeaderInterceptor: Interceptor {
    companion object {
        private const val X_API_KEY = "x-api-key"
    }
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder()
                .addHeader(X_API_KEY, Const.API_KEY)
                .build()
        )
    }
}
