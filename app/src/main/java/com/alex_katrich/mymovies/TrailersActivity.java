package com.alex_katrich.mymovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.alex_katrich.mymovies.modelVideo.Trailer;
import com.example.mymovies.R;
import com.alex_katrich.mymovies.modelVideo.TrailerDataCollection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class TrailersActivity extends AppCompatActivity {

    RecyclerView recyclerViewTrailers;
    RecyclerViewAdapterTrailers recyclerViewAdapterTrailers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailers);
        Objects.requireNonNull(getSupportActionBar()).hide();

        initialize();
        initializeRecyclerViewTrailer();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initialize() {

        Bundle bundle = getIntent().getBundleExtra("intentTrailers");
        Serializable bundledListOfTrailers = bundle.getSerializable("bundleTrailers");

        TrailerDataCollection.trailerArrayList = (ArrayList<Trailer>) bundledListOfTrailers;
    }

    private void initializeRecyclerViewTrailer() {
        recyclerViewTrailers = findViewById(R.id.recyclerViewTrailers);
        recyclerViewAdapterTrailers = new RecyclerViewAdapterTrailers(this);
        recyclerViewTrailers.setAdapter(recyclerViewAdapterTrailers);
        recyclerViewTrailers.setLayoutManager(
                new StaggeredGridLayoutManager(1, RecyclerView.VERTICAL));
    }
}