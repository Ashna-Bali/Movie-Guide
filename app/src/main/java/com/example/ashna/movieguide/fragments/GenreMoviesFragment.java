package com.example.ashna.movieguide.fragments;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ashna.movieguide.BuildConfig;
import com.example.ashna.movieguide.R;
import com.example.ashna.movieguide.adapters.MoviesAdapter;
import com.example.ashna.movieguide.api.Client;
import com.example.ashna.movieguide.database.FavoriteDbHelper;
import com.example.ashna.movieguide.database.tables.FavoriteTable;
import com.example.ashna.movieguide.models.Movie;
import com.example.ashna.movieguide.models.MovieResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class GenreMoviesFragment extends Fragment {


    public GenreMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_genre_movies, container, false);
        RecyclerView rvGenreMovies = rootView.findViewById(R.id.rvGenreMovies);
        final TextView tvCategory = rootView.findViewById(R.id.tvCategory);
        final MoviesAdapter moviesAdapter = new MoviesAdapter(new ArrayList<Movie>(), getActivity());
        rvGenreMovies.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvGenreMovies.setAdapter(moviesAdapter);

        if(getArguments().getString("category")!="Favorites"){

            Client.getInstance().getApi().getGenreMovies(getArguments().getInt("category_id"), BuildConfig.THE_MOVIE_DB_API_TOKEN)
                    .enqueue(new Callback<MovieResponse>() {
                        @Override
                        public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                            tvCategory.setText(getArguments().getString("category"));
                            moviesAdapter.setMovies(response.body().getResults());
                        }

                        @Override
                        public void onFailure(Call<MovieResponse> call, Throwable t) {

                        }
                    });
        }else{

            final SQLiteDatabase db = new FavoriteDbHelper(getActivity()).getReadableDatabase();
            Log.d("FAVORITES", "onCreateView: "+ FavoriteTable.getAllFavourites(db));
            tvCategory.setText(getArguments().getString("category"));
            moviesAdapter.setMovies(FavoriteTable.getAllFavourites(db));
        }
        return rootView;
    }

}
