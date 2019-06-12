package tech.burdzi0.ineedtofinishthisasap.model

import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("id") val id: Long,
    @SerializedName("url") val url: String,
    @SerializedName("since") val since: String,
    @SerializedName("expiration") val expiration: String
)