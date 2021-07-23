package taivu.uit.htttdd.tryrestapiwithretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient.Builder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


class APIClient {
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = Builder().addInterceptor(interceptor).build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit
    }

}