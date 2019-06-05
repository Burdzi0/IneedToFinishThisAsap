package tech.burdzi0.ineedtofinishthisasap.model

import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("url") val url: String,
    @SerializedName("since") val since: String,
    @SerializedName("expiration") val expiration: String
)