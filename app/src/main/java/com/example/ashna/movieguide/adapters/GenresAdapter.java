package com.example.ashna.movieguide.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ashna.movieguide.R;
import com.example.ashna.movieguide.models.Genre;

import java.util.ArrayList;

/**
 * Created by ASHNA on 14-10-2017.
 */

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.GenreViewHolder> {

    public static final String TAG = "GENRES";
    Context context;
    ArrayList<Genre> genres = new ArrayList<>();

    public GenresAdapter(Context context, ArrayList<Genre> genres) {
        this.context = context;
        this.genres = genres;
    }

    public void setGenres(ArrayList<Genre> genres){
        this.genres = genres;
        Log.d(TAG, "setGenres: "+genres);
        notifyDataSetChanged();
    }

    @Override
    public GenreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new GenreViewHolder(li.inflate(R.layout.list_item_genres, parent, false));
    }

    @Override
    public void onBindViewHolder(GenreViewHolder holder, int position) {
        holder.tvGenre.setText(genres.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    public class GenreViewHolder extends RecyclerView.ViewHolder {
        TextView tvGenre;
        public GenreViewHolder(View itemView) {
            super(itemView);
            tvGenre = itemView.findViewById(R.id.tvGenre);
        }
    }
}
