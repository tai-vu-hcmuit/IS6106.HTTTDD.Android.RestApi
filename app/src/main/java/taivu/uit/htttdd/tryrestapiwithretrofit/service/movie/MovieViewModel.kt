package taivu.uit.htttdd.tryrestapiwithretrofit.service.movie

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import taivu.uit.htttdd.tryrestapiwithretrofit.model.MovieResp
import taivu.uit.htttdd.tryrestapiwithretrofit.requestbuilder.RequestBuilder


class MovieViewModel : ViewModel() {
    companion object {
        private val TAG = MovieViewModel::class.java.simpleName
    }

    var nowPlayingMovies: MutableLiveData<MovieResp> = MutableLiveData<MovieResp>();

    init {
        Log.e("[${TAG}]", "Init view model")
    }

    fun getNowPlayingMovies() {
        viewModelScope.launch {
            val requestBuilder = RequestBuilder(
                MovieServiceConfig.BASE_URL,
                AuthenticationInterceptor()
            );
            val movieService = requestBuilder.createRequestBuilderForApi()
                .create(MovieDBService::class.java);

            Log.e("[${TAG}]", "Fetching data");

            nowPlayingMovies.value = movieService.listNowPlayingMovies(
                language = "en-US",
                page = 1
            )

            Log.e("[${TAG}]", nowPlayingMovies.value?.results?.get(0).toString());
        };
    }

    override fun onCleared() {
        super.onCleared()

        Log.e("[${TAG}]", "Clear View Model");
    }
}