package taivu.uit.htttdd.tryrestapiwithretrofit.service.movie

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url: HttpUrl = chain.request().url
            .newBuilder()
            .addQueryParameter("api_key", MovieServiceConfig.API_KEY)
            .build();

        val request: Request = chain.request().newBuilder().url(url).build();

        return chain.proceed(request);
    }
}