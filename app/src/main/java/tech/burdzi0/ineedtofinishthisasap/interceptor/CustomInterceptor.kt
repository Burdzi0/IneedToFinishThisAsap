package tech.burdzi0.ineedtofinishthisasap.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(request)
    }

}