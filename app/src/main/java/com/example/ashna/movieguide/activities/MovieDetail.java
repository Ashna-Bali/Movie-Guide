package com.example.ashna.movieguide.activities;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashna.movieguide.BuildConfig;
import com.example.ashna.movieguide.R;
import com.example.ashna.movieguide.adapters.TrailersAdapter;
import com.example.ashna.movieguide.api.Client;
import com.example.ashna.movieguide.database.FavoriteDbHelper;
import com.example.ashna.movieguide.database.tables.FavoriteTable;
import com.example.ashna.movieguide.models.Movie;
import com.example.ashna.movieguide.models.Trailer;
import com.example.ashna.movieguide.models.TrailerResponse;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetail extends AppCompatActivity {

    RecyclerView rvTrailers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ImageView ivBackdrop = (ImageView) findViewById(R.id.ivBackdrop);
        TextView tvMovieTitle = (TextView) findViewById(R.id.tvMovieTitle);
        TextView tvRating = (TextView) findViewById(R.id.tvRating);
        TextView tvReleaseDate = (TextView) findViewById(R.id.tvReleaseDate);
        TextView tvOverview = (TextView) findViewById(R.id.tvOverview);
        rvTrailers = (RecyclerView) findViewById(R.id.rvTrailers);
        final TrailersAdapter trailersAdapter = new TrailersAdapter(this, new ArrayList<Trailer>());
        rvTrailers.setLayoutManager(new LinearLayoutManager(this));
        rvTrailers.setAdapter(trailersAdapter);

        tvMovieTitle.setText(getIntent().getStringExtra("title")+((getIntent().getBooleanExtra("adult", false))?"(A)":"(U/A)"));
        tvRating.setText(String.valueOf(getIntent().getDoubleExtra("rating", 0)));
        tvReleaseDate.setText(getIntent().getStringExtra("date"));
        tvOverview.setText(getIntent().getStringExtra("overview"));
        Picasso.with(this).load(getIntent().getStringExtra("backdrop")).into(ivBackdrop);

        Client.getInstance().getApi().getMovieTrailers(getIntent().getIntExtra("movieId", 0), BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .enqueue(new Callback<TrailerResponse>() {
                    @Override
                    public void onResponse(Call<TrailerResponse> call, Response<TrailerResponse> response) {
                        trailersAdapter.setTrailers(response.body().getResults());
                    }

                    @Override
                    public void onFailure(Call<TrailerResponse> call, Throwable t) {

                    }
                });

        MaterialFavoriteButton btnFavorite = (MaterialFavoriteButton) findViewById(R.id.btnFavorite);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SQLiteDatabase db = new FavoriteDbHelper(this).getWritableDatabase();

        final Integer id = getIntent().getIntExtra("movieId", 0);
        final String releaseDate = getIntent().getStringExtra("date");
        final String backdrop = getIntent().getStringExtra("backdropPath");
        final String poster = getIntent().getStringExtra("posterPath");
        final String title = getIntent().getStringExtra("title");
        final String overview = getIntent().getStringExtra("overview");
        final Double rating = getIntent().getDoubleExtra("rating", 0);
        final Boolean adult = getIntent().getBooleanExtra("adult", false);
        btnFavorite.setOnFavoriteChangeListener(new MaterialFavoriteButton.OnFavoriteChangeListener() {
            @Override
            public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {

                if(favorite){

                    SharedPreferences.Editor editor = getSharedPreferences(
                            "com.example.ashna.movieguide",
                            MODE_PRIVATE
                    ).edit();

                    editor.putBoolean("Favorite Added", true);
                    editor.commit();
                    long favoriteId = FavoriteTable.insertFavorite(
                            new Movie(id, backdrop, poster, title, releaseDate, rating, overview, adult),
                            db
                    );
                    Toast.makeText(MovieDetail.this, "Added to Favorites", Toast.LENGTH_SHORT).show();
                }else{
                    SharedPreferences.Editor editor = getSharedPreferences(
                            "com.example.ashna.movieguide",
                            MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("Favorite Added", false);
                    editor.commit();
                    long favoriteId = FavoriteTable.deleteFavorite(id, db);
                    Toast.makeText(MovieDetail.this, "Removed from Favorites", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
