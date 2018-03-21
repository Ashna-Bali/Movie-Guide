package com.example.ashna.movieguide;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.example.ashna.movieguide.adapters.MoviesAdapter;
import com.example.ashna.movieguide.api.Client;
import com.example.ashna.movieguide.fragments.GenresFragment;
import com.example.ashna.movieguide.fragments.MainFrameFragment;
import com.example.ashna.movieguide.fragments.SearchedMovieFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    MainFrameFragment mainFrameFragment = new MainFrameFragment();
    ImageButton ibSearch, ibMore, ibBack;
    EditText etMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        ibSearch = (ImageButton) findViewById(R.id.ibSearch);
        ibMore = (ImageButton) findViewById(R.id.ibMore);
        ibBack = (ImageButton) findViewById(R.id.ibBack);
        etMovie = (EditText) findViewById(R.id.etMovie);
        beginMainFrame();

        ibSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchedMovieFragment searchedMovieFragment = new SearchedMovieFragment();
                Bundle args = new Bundle();
                args.putString("movieName", etMovie.getText().toString());
                searchedMovieFragment.setArguments(args);
                etMovie.setText("");
                fragmentManager.beginTransaction().replace(R.id.flFragContainer, searchedMovieFragment).commit();
            }
        });

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beginMainFrame();
            }
        });

        ibMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GenresFragment genresFragment = new GenresFragment();
                fragmentManager.beginTransaction().replace(R.id.flFragContainer, genresFragment).commit();
            }
        });
    }

    private void beginMainFrame() {
        fragmentManager.beginTransaction().replace(R.id.flFragContainer, mainFrameFragment).commit();
    }
}
