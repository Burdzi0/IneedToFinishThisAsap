package tech.burdzi0.ineedtofinishthisasap.model.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.burdzi0.ineedtofinishthisasap.interceptor.CustomInterceptor

object RetrofitProvider {

    private val REST_API_WEBSITE = "http://bootshorten.herokuapp.com/"

    private val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(REST_API_WEBSITE)
            .client(createCustomInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createCustomInterceptor(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(CustomInterceptor())
            .addNetworkInterceptor(CustomInterceptor())
            .retryOnConnectionFailure(true)
            .build()
    }

    fun get(): Retrofit {
        return instance
    }
}