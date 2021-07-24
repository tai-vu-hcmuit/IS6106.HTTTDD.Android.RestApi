package taivu.uit.htttdd.tryrestapiwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import taivu.uit.htttdd.tryrestapiwithretrofit.service.movie.MovieViewModel

class MainActivity : AppCompatActivity() {
    lateinit var movieVM: MovieViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.movieVM = ViewModelProvider(this).get(MovieViewModel::class.java)

        this.movieVM.nowPlayingMovies.observe(this, Observer {
            val txtResultView = findViewById<TextView>(R.id.result_container);

            txtResultView.text = this.movieVM.nowPlayingMovies.value?.results?.get(0)?.title.toString()
            Log.e("[Main Activity]", "Update now playing movies")
        })
    }

    fun handleClickCallAPI(view: View) {
        val txtResultView = findViewById<TextView>(R.id.result_container);

        txtResultView.text = getString(R.string.status_fetching);
        this.movieVM.getNowPlayingMovies();
    }
}