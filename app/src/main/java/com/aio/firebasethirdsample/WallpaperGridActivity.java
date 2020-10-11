package com.aio.firebasethirdsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
public class WallpaperGridActivity extends AppCompatActivity {

    private RecyclerView gridrecyclerView;
    private WallpaperPostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper_grid);
//        ActionBar bar = getActionBar();
//        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#121212")));

        gridrecyclerView = findViewById(R.id.gridrecycler);
        // horiznatal scrolling recyclerview
        //gridrecyclerView.setHasFixedSize(true);
        //gridrecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //gridrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        gridrecyclerView.setLayoutManager(new GridLayoutManager(this,3));

        FirebaseRecyclerOptions<WallpaperPost> options =
                new FirebaseRecyclerOptions.Builder<WallpaperPost>()
                        //i will be using the same Post.class as for PostListActivity
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("UserOne"), WallpaperPost.class)
                        .build();

        adapter = new WallpaperPostAdapter(options);
        gridrecyclerView.setAdapter(adapter);

		//clickable recycler full view item
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(this, FullViewActivityName.class);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}