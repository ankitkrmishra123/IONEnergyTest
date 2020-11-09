package com.exapmle.ionenergytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static RecyclerView recyclerView;
    private static RecyclerView.Adapter adapter;
    private static List<MovieListItems> data;
    public static List<WholeItemListOfSingleMovie> wholeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initstate();
        callTrendingMovieApi();
    }


    private void initstate() {
        data = new ArrayList<>();
        wholeData = new ArrayList<>();
        recyclerView = findViewById(R.id.TrendMovieRecyclerview);
    }




    private void callTrendingMovieApi() {
        RequestQueue queue = Volley.newRequestQueue(this);

        final String url = "https://api.themoviedb.org/3/trending/movie/week?api_key=df87b826407ba02cde5a1df3dcefc4c7";

// prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", response.toString());
                        loadRecyclerViewData(response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        );

// add it to the RequestQueue
        queue.add(getRequest);
    }

    private void loadRecyclerViewData(JSONObject response) {
        try {
            JSONArray ja = response.getJSONArray("results");
            for(int i=0; i<ja.length(); i++){
                JSONObject temp = ja.getJSONObject(i);
                MovieListItems mvl = new MovieListItems("https://image.tmdb.org/t/p/w500"+temp.getString("poster_path"), temp.getString("title"), temp.getString("vote_average"));
                data.add(mvl);
                WholeItemListOfSingleMovie wilsm = new WholeItemListOfSingleMovie("https://image.tmdb.org/t/p/w500"+temp.getString("backdrop_path"), temp.getString("title"), temp.getString("vote_average"),temp.getString("vote_count"),temp.getString("release_date"),temp.getBoolean("adult"),temp.getString("overview"),temp.getDouble("popularity"),temp.getString("media_type"));
                wholeData.add(wilsm);
            }

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new MovieListAdapter(data, this); //WD -> work detail
            recyclerView.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}