package taivu.uit.htttdd.tryrestapiwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import taivu.uit.htttdd.tryrestapiwithretrofit.service.movie.MovieFetcherByCoroutine

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun handleClickCallAPI(view: View) {
        val txtResultView = findViewById<TextView>(R.id.result_container);
        val movieFetcher = MovieFetcherByCoroutine();

        txtResultView.text = getString(R.string.status_fetching);
        movieFetcher.getNowPlayingMovies();

        txtResultView.text = getString(R.string.status_fetched);
    }
}