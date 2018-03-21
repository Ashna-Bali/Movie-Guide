package com.example.ashna.movieguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ashna.movieguide.R;
import com.example.ashna.movieguide.models.Trailer;

import java.util.ArrayList;

/**
 * Created by ASHNA on 15-10-2017.
 */

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.TrailerViewHolder>{

    Context context;
    ArrayList<Trailer> trailers;

    public TrailersAdapter(Context context, ArrayList<Trailer> trailers) {
        this.context = context;
        this.trailers = trailers;
    }

    public void setTrailers(ArrayList<Trailer> trailers){
        this.trailers = trailers;
        notifyDataSetChanged();
    }

    @Override
    public TrailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new TrailerViewHolder(li.inflate(R.layout.list_item_trailer, parent, false));
    }

    @Override
    public void onBindViewHolder(TrailerViewHolder holder, int position) {
        holder.bindView(trailers.get(position));
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    public class TrailerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTrailerName;
        public TrailerViewHolder(View itemView) {
            super(itemView);
            tvTrailerName = itemView.findViewById(R.id.tvTrailerName);
        }
        public void bindView(Trailer trailer){
            tvTrailerName.setText(trailer.getName());
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+ trailers.get(pos).getKey()));
            context.startActivity(i);
        }
    }
}
