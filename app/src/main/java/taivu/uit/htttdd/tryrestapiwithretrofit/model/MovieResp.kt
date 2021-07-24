package taivu.uit.htttdd.tryrestapiwithretrofit.model

import com.google.gson.annotations.SerializedName

data class MovieResp (

    val dates: Dates? = null,
    val page: Long? = null,
    val results: List<Movie>? = null,

    @SerializedName("total_pages")
    val totalPages: Long? = null,

    @SerializedName("total_results")
    val totalResults: Long? = null

)

data class Dates (
    val maximum: String? =null,
    val minimum: String? = null
)