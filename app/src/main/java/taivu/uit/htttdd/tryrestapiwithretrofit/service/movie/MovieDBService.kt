package taivu.uit.htttdd.tryrestapiwithretrofit.service.movie

import taivu.uit.htttdd.tryrestapiwithretrofit.model.MovieResp
import retrofit2.http.GET
import retrofit2.http.Query

object MovieServiceConfig {
    const val BASE_URL: String = "https://api.themoviedb.org/3/"
    const val BASE_RESOURCE_URL: String = "https://image.tmdb.org/t/p/w500"
    const val API_KEY: String = "7519cb3f829ecd53bd9b7007076dbe23"
    const val ENDPOINT_NOW_PLAYING_MOVIES: String = "movie/now_playing"
    const val ENDPOINT_UP_COMING_MOVIES: String = "movie/upcoming"
}

interface MovieDBService {

    @GET(MovieServiceConfig.ENDPOINT_NOW_PLAYING_MOVIES)
    suspend fun listNowPlayingMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ) : MovieResp

    @GET(MovieServiceConfig.ENDPOINT_UP_COMING_MOVIES)
    suspend fun listUpComingMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): MovieResp
}