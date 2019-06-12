package tech.burdzi0.ineedtofinishthisasap.model.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.burdzi0.ineedtofinishthisasap.interceptor.CustomInterceptor
import java.util.concurrent.TimeUnit

object RetrofitProvider {

    private const val BASE_URL = "http://bootshorten.herokuapp.com/"

    private val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createCustomInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createCustomInterceptor(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(CustomInterceptor())
            .addNetworkInterceptor(CustomInterceptor())
            .retryOnConnectionFailure(true)
            .callTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    fun get(): Retrofit {
        return instance
    }
}