package taivu.uit.htttdd.tryrestapiwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import taivu.uit.htttdd.tryrestapiwithretrofit.service.movie.MovieViewModel

class MainActivity : AppCompatActivity() {
    lateinit var movieVM: MovieViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.movieVM = ViewModelProvider(this).get(MovieViewModel::class.java)
    }

    fun handleClickCallAPI(view: View) {
        val txtResultView = findViewById<TextView>(R.id.result_container);

        txtResultView.text = getString(R.string.status_fetching);

        this.movieVM.getNowPlayingMovies();

        txtResultView.text = getString(R.string.status_fetched);
    }

    fun handleClickTest(view: View) {
        val txtResultView = findViewById<TextView>(R.id.result_container);

        if(this.movieVM.nowPlayingMovies == null) {
            txtResultView.text = "Need to fetch data first!";
            return;
        }

        val movie = this.movieVM.nowPlayingMovies?.results?.get(0) ?: return;
        txtResultView.text = movie.title.toString();

        Log.e("[Main Activity]", movie.title.toString());
    }
}