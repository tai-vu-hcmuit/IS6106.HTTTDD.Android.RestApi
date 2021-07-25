package taivu.uit.htttdd.tryrestapiwithretrofit.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import taivu.uit.htttdd.tryrestapiwithretrofit.R
import taivu.uit.htttdd.tryrestapiwithretrofit.model.Movie
import taivu.uit.htttdd.tryrestapiwithretrofit.service.movie.MovieDBService
import taivu.uit.htttdd.tryrestapiwithretrofit.service.movie.MovieServiceConfig

class MovieListAdapter (private var movieList: List<Movie>) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgThumbnail: ImageView = itemView.findViewById(R.id.movie_thumbnail)
        val txTitle: TextView = itemView.findViewById(R.id.movie_title)
        val txtReleaseDate: TextView = itemView.findViewById(R.id.release_date)
        val txtVoteAverage: TextView = itemView.findViewById(R.id.vote_average)

        init {
            itemView.setOnClickListener { view: View ->
                val position: Int = absoluteAdapterPosition

                Toast.makeText(itemView.context, "You clicked on item #${position + 1}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_movie_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.imgThumbnail.setImageURI(MovieServiceConfig.BASE_RESOURCE_URL + movieList[position].backdropPath)
        holder.txTitle.text = movieList[position].title
        holder.txtReleaseDate.text = movieList[position].releaseDate
        holder.txtVoteAverage.text = movieList[position].voteAverage.toString()
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}