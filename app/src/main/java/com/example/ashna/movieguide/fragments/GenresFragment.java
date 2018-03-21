package com.example.ashna.movieguide.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashna.movieguide.BuildConfig;
import com.example.ashna.movieguide.MainActivity;
import com.example.ashna.movieguide.R;
import com.example.ashna.movieguide.adapters.GenresAdapter;
import com.example.ashna.movieguide.api.Client;
import com.example.ashna.movieguide.models.Genre;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class GenresFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "RESPONSE";

    public GenresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_genres, container, false);
        TextView tvAction = rootView.findViewById(R.id.tvAction);
        TextView tvAdventure = rootView.findViewById(R.id.tvAdventure);
        TextView tvAnimation = rootView.findViewById(R.id.tvAnimation);
        TextView tvComedy = rootView.findViewById(R.id.tvComedy);
        TextView tvCrime = rootView.findViewById(R.id.tvCrime);
        TextView tvDrama = rootView.findViewById(R.id.tvDrama);
        TextView tvDocumentary = rootView.findViewById(R.id.tvDocumentary);
        TextView tvFamily = rootView.findViewById(R.id.tvFamily);
        TextView tvFantasy = rootView.findViewById(R.id.tvFantasy);
        TextView tvHistory = rootView.findViewById(R.id.tvHistory);
        TextView tvHorror = rootView.findViewById(R.id.tvHorror);
        TextView tvRomance = rootView.findViewById(R.id.tvRomance);
        TextView tvScienceFiction = rootView.findViewById(R.id.tvScienceFiction);
        TextView tvTvMovie = rootView.findViewById(R.id.tvTvMovie);
        TextView tvThriller = rootView.findViewById(R.id.tvThriller);
        TextView tvWar = rootView.findViewById(R.id.tvWar);
        TextView tvMystery = rootView.findViewById(R.id.tvMystery);
        TextView tvMusic = rootView.findViewById(R.id.tvMusic);
        TextView tvWestern = rootView.findViewById(R.id.tvWestern);
        TextView tvFavorites = rootView.findViewById(R.id.tvFavorites);
//        RecyclerView rvGenres = rootView.findViewById(R.id.rvGenres);
//        final GenresAdapter genresAdapter = new GenresAdapter(getActivity(), new ArrayList<Genre>());
//        rvGenres.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//        rvGenres.setAdapter(genresAdapter);
//
//        Client.getInstance().getApi().getGenreList(BuildConfig.THE_MOVIE_DB_API_TOKEN)
//                .enqueue(new Callback<ArrayList<Genre>>() {
//                    @Override
//                    public void onResponse(Call<ArrayList<Genre>> call, Response<ArrayList<Genre>> response) {
//                        Log.d(TAG, "onResponse: "+response.body());
//                        genresAdapter.setGenres(response.body());
//                    }
//
//                    @Override
//                    public void onFailure(Call<ArrayList<Genre>> call, Throwable t) {
//                        Toast.makeText(getActivity(), "FAILURE OCCURRED", Toast.LENGTH_SHORT).show();
//                    }
//                });
        tvAction.setOnClickListener(this);
        tvAdventure.setOnClickListener(this);
        tvAnimation.setOnClickListener(this);
        tvComedy.setOnClickListener(this);
        tvCrime.setOnClickListener(this);
        tvDrama.setOnClickListener(this);
        tvDocumentary.setOnClickListener(this);
        tvHistory.setOnClickListener(this);
        tvHorror.setOnClickListener(this);
        tvFamily.setOnClickListener(this);
        tvMusic.setOnClickListener(this);
        tvMystery.setOnClickListener(this);
        tvScienceFiction.setOnClickListener(this);
        tvThriller.setOnClickListener(this);
        tvTvMovie.setOnClickListener(this);
        tvRomance.setOnClickListener(this);
        tvWar.setOnClickListener(this);
        tvWestern.setOnClickListener(this);
        tvFantasy.setOnClickListener(this);
        tvFavorites.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        Bundle args = new Bundle();
        GenreMoviesFragment fragment = new GenreMoviesFragment();
        MainActivity myActivity = (MainActivity)getActivity();
        FragmentManager manager = myActivity.getSupportFragmentManager();
        switch(view.getId()){

            case R.id.tvAction :
                args.putString("category", "Action");
                args.putInt("category_id", 28);
                fragment.setArguments(args);
                break;

            case R.id.tvAdventure :
                args.putString("category", "Adventure");
                args.putInt("category_id", 12);
                fragment.setArguments(args);
                break;

            case R.id.tvAnimation :
                args.putString("category", "Animation");
                args.putInt("category_id", 16);
                fragment.setArguments(args);
                break;

            case R.id.tvComedy :
                args.putString("category", "Comedy");
                args.putInt("category_id", 35);
                fragment.setArguments(args);
                break;

            case R.id.tvCrime :
                args.putString("category", "Crime");
                args.putInt("category_id", 80);
                fragment.setArguments(args);
                break;

            case R.id.tvDocumentary :
                args.putString("category", "Documentary");
                args.putInt("category_id", 99);
                fragment.setArguments(args);
                break;

            case R.id.tvDrama :
                args.putString("category", "Drama");
                args.putInt("category_id", 18);
                fragment.setArguments(args);
                break;

            case R.id.tvFamily :
                args.putString("category", "Family");
                args.putInt("category_id", 10751);
                fragment.setArguments(args);
                break;

            case R.id.tvFantasy :
                args.putString("category", "Fantasy");
                args.putInt("category_id", 14);
                fragment.setArguments(args);
                break;

            case R.id.tvHistory :
                args.putString("category", "History");
                args.putInt("category_id", 36);
                fragment.setArguments(args);
                break;

            case R.id.tvHorror :
                args.putString("category", "Horror");
                args.putInt("category_id", 27);
                fragment.setArguments(args);
                break;

            case R.id.tvMusic :
                args.putString("category", "Music");
                args.putInt("category_id", 10402);
                fragment.setArguments(args);
                break;

            case R.id.tvMystery :
                args.putString("category", "Mystery");
                args.putInt("category_id", 9648);
                fragment.setArguments(args);
                break;

            case R.id.tvRomance :
                args.putString("category", "Romance");
                args.putInt("category_id", 10749);
                fragment.setArguments(args);
                break;

            case R.id.tvScienceFiction :
                args.putString("category", "Science Fiction");
                args.putInt("category_id", 878);
                fragment.setArguments(args);
                break;

            case R.id.tvTvMovie :
                args.putString("category", "TV Movie");
                args.putInt("category_id", 10770);
                fragment.setArguments(args);
                break;

            case R.id.tvThriller :
                args.putString("category", "Thriller");
                args.putInt("category_id", 53);
                fragment.setArguments(args);
                break;

            case R.id.tvWar :
                args.putString("category", "War");
                args.putInt("category_id", 10752);
                fragment.setArguments(args);
                break;

            case R.id.tvWestern :
                args.putString("category", "Western");
                args.putInt("category_id", 37);
                fragment.setArguments(args);
                break;

            case R.id.tvFavorites :
                args.putString("category", "Favorites");
                fragment.setArguments(args);
        }

        manager.beginTransaction().replace(R.id.flFragContainer, fragment).commit();
    }
}
