package tech.burdzi0.ineedtofinishthisasap.model.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import tech.burdzi0.ineedtofinishthisasap.model.Link

interface LinkRetrofitService {

    @GET("/api/link/")
    fun getAllLinks(): Call<List<Link>>

    @GET("/api/link/{id}")
    fun getLinkById(@Path("id") id:Long): Call<Link>

    @POST("/api/link")
    fun postLink(link:Link): Call<Link>
}