package tech.burdzi0.ineedtofinishthisasap.model.api

object LinkServiceProvider {

    private val instance: LinkRetrofitService by lazy {
        val retrofit = RetrofitProvider.get()
        retrofit.create(LinkRetrofitService::class.java)
    }

    fun get():LinkRetrofitService {
        return instance
    }
}