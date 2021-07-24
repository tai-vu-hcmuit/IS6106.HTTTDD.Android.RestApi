package taivu.uit.htttdd.tryrestapiwithretrofit.requestbuilder

import okhttp3.OkHttpClient
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RequestBuilder(interceptor: Interceptor? = null) {
    lateinit var httpClient: OkHttpClient;
    lateinit var baseUrl: String;
    // var interceptor: Interceptor? = null;

    constructor(baseUrl: String, interceptor: Interceptor? = null) : this() {
        if(interceptor != null) {
            // this.interceptor = interceptor;

            this.httpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .build();
        }
        else {
            this.httpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .build();
        }

        this.baseUrl = baseUrl;
    }

    fun createRequestBuilderForApi(): Retrofit {
        return Retrofit.Builder().baseUrl(this.baseUrl)
            .client(this.httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}