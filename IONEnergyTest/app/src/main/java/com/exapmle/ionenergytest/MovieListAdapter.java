package com.exapmle.ionenergytest;

import android.content.Context;

import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


import java.util.List;

class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    public static MovieListAdapter instance;
    List<MovieListItems> itemList;
    Context context;

    public MovieListAdapter(List<MovieListItems> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
        instance = this;
    }

    @NonNull
    @Override
    public MovieListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listof_trending_movies, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieListAdapter.ViewHolder holder, int position) {

        MovieListItems mvl = itemList.get(position);

        setImagePoster(holder, mvl);

        holder.movieName.setText(Html.fromHtml("<font color=#00FF00>Name: </font> <strong>"+mvl.getMovieName()+"</strong>"));

        holder.movieRating.setText(Html.fromHtml("<font color=#00FF00>Rating: </font> <strong>"+mvl.getMovieRating()+"</strong>"));

        holder.moviePoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPerticularMovieDetail(holder);
            }
        });

    }

    private void goToPerticularMovieDetail(ViewHolder holder) {
        Intent i = new Intent(context, PerticularMovieDetail.class);
        i.putExtra("adapterPosition", holder.getAdapterPosition());
        context.startActivity(i);
    }

    private void setImagePoster(ViewHolder holder, MovieListItems mvl) {

        Picasso.get()
                .load(mvl.getMovieUrl())
                .resize(800, 800)
                .centerCrop()
                .into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView moviePoster;
        TextView movieName, movieRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            moviePoster = itemView.findViewById(R.id.moviePoster);
            movieName = itemView.findViewById(R.id.movieName);
            movieRating = itemView.findViewById(R.id.movieRating);

        }
    }
}