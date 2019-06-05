package tech.burdzi0.ineedtofinishthisasap.model.api

object LinkServiceProvider {

    private val instance: LinkService by lazy {
        val retrofit = RetrofitProvider.get()
        retrofit.create(LinkService::class.java)
    }

    fun get():LinkService {
        return instance
    }
}