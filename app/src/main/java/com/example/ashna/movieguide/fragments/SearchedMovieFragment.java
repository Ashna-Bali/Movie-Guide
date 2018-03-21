package com.example.ashna.movieguide.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ashna.movieguide.BuildConfig;
import com.example.ashna.movieguide.R;
import com.example.ashna.movieguide.adapters.MoviesAdapter;
import com.example.ashna.movieguide.api.Client;
import com.example.ashna.movieguide.models.Movie;
import com.example.ashna.movieguide.models.MovieResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchedMovieFragment extends Fragment {


    public SearchedMovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_searched_movie, container, false);
        RecyclerView rvSearchedMovie = rootView.findViewById(R.id.rvSearchedMovie);
        final MoviesAdapter adapter = new MoviesAdapter(new ArrayList<Movie>(),getActivity());
        String query = getArguments().getString("movieName");
        rvSearchedMovie.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvSearchedMovie.setAdapter(adapter);

        Client.getInstance().getApi().getSearchedMovie(BuildConfig.THE_MOVIE_DB_API_TOKEN, query)
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        adapter.setMovies(response.body().getResults());
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {

                    }
                });
        return rootView;
    }

}
