package taivu.uit.htttdd.tryrestapiwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import taivu.uit.htttdd.tryrestapiwithretrofit.model.Movie
import taivu.uit.htttdd.tryrestapiwithretrofit.service.movie.MovieViewModel
import taivu.uit.htttdd.tryrestapiwithretrofit.ui.MovieListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var movieVM: MovieViewModel;

    private var movieList = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.movieVM = ViewModelProvider(this).get(MovieViewModel::class.java)

        this.movieVM.nowPlayingMovies.observe(this, Observer {
            val txtResultView = findViewById<TextView>(R.id.result_container);

            txtResultView.text = getString(R.string.status_fetched);
            this.movieList = this.movieVM.nowPlayingMovies.value?.results?.toMutableList() ?: mutableListOf<Movie>()

            val rvMovieList = findViewById<RecyclerView>(R.id.recycle_view_data)
            rvMovieList.layoutManager = LinearLayoutManager(this)
            rvMovieList.adapter = MovieListAdapter(movieList)

            Log.e("[Main Activity]", "Update now playing movies")
        })

        this.prepareEmptyMovieList();
    }

    fun handleClickCallAPI(view: View) {
        val txtResultView = findViewById<TextView>(R.id.result_container);

        txtResultView.text = getString(R.string.status_fetching);
        this.movieVM.getNowPlayingMovies();
    }

    private fun prepareEmptyMovieList() {
        val movie = Movie(
            title = "No data",
            releaseDate = "No data",
            voteAverage = 0.0,
            posterPath = ""
        )
        movieList.add(movie);

        val rvMovieList = findViewById<RecyclerView>(R.id.recycle_view_data)
        rvMovieList.layoutManager = LinearLayoutManager(this)
        rvMovieList.adapter = MovieListAdapter(movieList)
    }
}