package com.example.ashna.movieguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashna.movieguide.MainActivity;
import com.example.ashna.movieguide.activities.MovieDetail;
import com.example.ashna.movieguide.R;
import com.example.ashna.movieguide.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ASHNA on 12-10-2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private ArrayList<Movie> movies = new ArrayList<>();
    private Context context;

    public MoviesAdapter(ArrayList<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    public void setMovies(ArrayList<Movie> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new MovieViewHolder(li.inflate(R.layout.list_item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bindView(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvTitle, tvRating;
        ImageView ivPoster;
//        MainActivity myActivity = (MainActivity)context;
        public MovieViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvRating = itemView.findViewById(R.id.tvRating);
            ivPoster = itemView.findViewById(R.id.ivPoster);
        }

        public void bindView(Movie movie){
            tvTitle.setText(movie.getTitle());
            tvRating.setText(movie.getVote_average().toString());
            Picasso.with(context).load(movie.getPoster_path()).into(ivPoster);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {

            Intent i = new Intent(context, MovieDetail.class);
            i.putExtra("backdrop", movies.get(getAdapterPosition()).getBackdrop_path());
            i.putExtra("poster", movies.get(getAdapterPosition()).getPoster_path());
            i.putExtra("title", movies.get(getAdapterPosition()).getTitle());
            i.putExtra("date", movies.get(getAdapterPosition()).getRelease_date());
            i.putExtra("rating", movies.get(getAdapterPosition()).getVote_average());
            i.putExtra("overview", movies.get(getAdapterPosition()).getOverview());
            i.putExtra("adult", movies.get(getAdapterPosition()).isAdult());
            i.putExtra("movieId", movies.get(getAdapterPosition()).getId());
            i.putExtra("backdropPath", movies.get(getAdapterPosition()).getBackdropPath());
            i.putExtra("posterPath", movies.get(getAdapterPosition()).getPosterPath());
            context.startActivity(i);
//            FragmentManager fragmentManager = myActivity.getSupportFragmentManager();
//            MovieDetailFragment fragment = new MovieDetailFragment();
//            Bundle args = new Bundle();
//            args.putString("backdrop", movies.get(getAdapterPosition()).getBackdrop_path());
//            args.putString("title", movies.get(getAdapterPosition()).getTitle());
//            args.putString("date", movies.get(getAdapterPosition()).getRelease_date());
//            args.putInt("rating", movies.get(getAdapterPosition()).getVote_count());
//            args.putString("overview", movies.get(getAdapterPosition()).getOverview());
//            args.putBoolean("adult", movies.get(getAdapterPosition()).isAdult());
//            fragment.setArguments(args);
//            fragmentManager.beginTransaction().replace(R.id.flFragContainer, fragment).commit();
        }
    }


}
