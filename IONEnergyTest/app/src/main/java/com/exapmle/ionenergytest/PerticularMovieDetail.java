package com.exapmle.ionenergytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PerticularMovieDetail extends AppCompatActivity {

    int adapterPosition;
    ImageView moviePoster;
    TextView movieName, movieRating, movieVoteCount, releaseDate, adult, overview, popularity, mediaType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perticular_movie_detail);

        adapterPosition = (int) getIntent().getExtras().get("adapterPosition");

        initState();


        WholeItemListOfSingleMovie wilsm = MainActivity.wholeData.get(adapterPosition);
        setDataForPerticularMovie(wilsm);


    }

    private void setDataForPerticularMovie(WholeItemListOfSingleMovie wilsm) {
        Picasso.get()
                .load(wilsm.getMovieUrl())
                .resize(800, 800)
                .centerCrop()
                .into(moviePoster);

        movieName.setText(Html.fromHtml("<font color=#00FF00>Name: </font> <strong>"+wilsm.getMovieName()+"</strong>"));

        movieRating.setText(Html.fromHtml("<font color=#00FF00>Movie Rating: </font> <strong>"+wilsm.getMovieRating()+"</strong>"));

        movieVoteCount.setText(Html.fromHtml("<font color=#00FF00>Movie Vote Count: </font> <strong>"+wilsm.getMovieVoteCount()+"</strong>"));

        releaseDate.setText(Html.fromHtml("<font color=#00FF00>Movie release Date: </font> <strong>"+wilsm.getReleaseDate()+"</strong>"));

        adult.setText(Html.fromHtml("<font color=#00FF00>adult: </font> <strong>"+ getAdultOrNot(wilsm)+"</strong>"));

        overview.setText(Html.fromHtml("<font color=#00FF00>Overview: </font> <strong>"+wilsm.getOverview()+"</strong>"));

        popularity.setText(Html.fromHtml("<font color=#00FF00>Popularity: </font> <strong>"+wilsm.getPopularity()+"</strong>"));

        mediaType.setText(Html.fromHtml("<font color=#00FF00>Media Type: </font> <strong>"+wilsm.getMediaType()+"</strong>"));
    }

    private String getAdultOrNot(WholeItemListOfSingleMovie wilsm) {
        String temp = wilsm.getAdult() ? "Yes" : "No" ;
        return temp;
    }

    private void initState() {
        moviePoster = findViewById(R.id.moviePoster);
        movieName = findViewById(R.id.movieName);
        movieRating = findViewById(R.id.movieRating);
        movieVoteCount = findViewById(R.id.movieVoteCount);
        releaseDate = findViewById(R.id.releaseDate);
        adult = findViewById(R.id.adult);
        overview = findViewById(R.id.overview);
        popularity = findViewById(R.id.popularity);
        mediaType = findViewById(R.id.mediaType);
    }
}