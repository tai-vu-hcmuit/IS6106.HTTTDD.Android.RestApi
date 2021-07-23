package taivu.uit.htttdd.tryrestapiwithretrofit.pojo

import com.google.gson.annotations.SerializedName;

class User {
    @SerializedName("name")
    var name: String? = null

    @SerializedName("job")
    var job: String? = null

    @SerializedName("id")
    var id: String? = null

    @SerializedName("createdAt")
    var createdAt: String? = null

    fun User(name: String?, job: String?) {
        this.name = name
        this.job = job
    }
}