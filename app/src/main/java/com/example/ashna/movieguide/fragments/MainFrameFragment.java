package com.example.ashna.movieguide.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ashna.movieguide.BuildConfig;
import com.example.ashna.movieguide.MainActivity;
import com.example.ashna.movieguide.R;
import com.example.ashna.movieguide.adapters.MoviesAdapter;
import com.example.ashna.movieguide.api.Client;
import com.example.ashna.movieguide.models.Movie;
import com.example.ashna.movieguide.models.MovieResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFrameFragment extends Fragment {

    public static final String TAG = "RESPONSE";

    public MainFrameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main_frame, container, false);
        final ProgressBar pbPopular = rootView.findViewById(R.id.pbPopular);
        final ProgressBar pbTopRated = rootView.findViewById(R.id.pbTopRated);
        final ProgressBar pbNowPlaying = rootView.findViewById(R.id.pbNowPlaying);
        final ProgressBar pbUpcoming = rootView.findViewById(R.id.pbUpcoming);
        RecyclerView rvPopular = rootView.findViewById(R.id.rvPopular);
        RecyclerView rvUpcoming = rootView.findViewById(R.id.rvUpcoming);
        RecyclerView rvNowPlaying = rootView.findViewById(R.id.rvNowPlaying);
        RecyclerView rvTopRated = rootView.findViewById(R.id.rvTopRated);
        final ArrayList<Movie> popularMovies;

        pbPopular.setIndeterminate(true);
        pbTopRated.setIndeterminate(true);
        pbNowPlaying.setIndeterminate(true);
        pbUpcoming.setIndeterminate(true);

        final MoviesAdapter popularAdapter = new MoviesAdapter(new ArrayList<Movie>(), getContext());
        rvPopular.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvPopular.setAdapter(popularAdapter);

        final MoviesAdapter upcomingAdapter = new MoviesAdapter(new ArrayList<Movie>(), getActivity());
        rvUpcoming.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvUpcoming.setAdapter(upcomingAdapter);

        final MoviesAdapter nowPlayingAdapter = new MoviesAdapter(new ArrayList<Movie>(), getActivity());
        rvNowPlaying.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvNowPlaying.setAdapter(nowPlayingAdapter);

        final MoviesAdapter topRatedAdapter = new MoviesAdapter(new ArrayList<Movie>(), getActivity());
        rvTopRated.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvTopRated.setAdapter(topRatedAdapter);

        Client.getInstance().getApi().getPopularMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        pbPopular.setIndeterminate(false);
                        pbPopular.setVisibility(GONE);
                        popularAdapter.setMovies(response.body().getResults());
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                        Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });

        Client.getInstance().getApi().getUpcomingMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        pbUpcoming.setIndeterminate(false);
                        pbUpcoming.setVisibility(GONE);
                        upcomingAdapter.setMovies(response.body().getResults());
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {

                    }
                });

        Client.getInstance().getApi().getNowPlayingMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        pbNowPlaying.setIndeterminate(false);
                        pbNowPlaying.setVisibility(GONE);
                        nowPlayingAdapter.setMovies(response.body().getResults());
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {

                    }
                });

        Client.getInstance().getApi().getTopRatedMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        pbTopRated.setIndeterminate(false);
                        pbTopRated.setVisibility(GONE);
                        topRatedAdapter.setMovies(response.body().getResults());
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {

                    }
                });

        return rootView;
    }

}
