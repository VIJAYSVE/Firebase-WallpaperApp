package com.aio.firebasethirdsample;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseError;
import com.squareup.picasso.Picasso;

import android.os.Bundle;

public class PostAdapter extends FirebaseRecyclerAdapter<Post, PostAdapter.PastViewHolder> {


    public PostAdapter(@NonNull FirebaseRecyclerOptions<Post> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull PastViewHolder holder, int i, @NonNull Post post) {
        holder.mobile.setText(post.getMobile());
        holder.title.setText(post.getTitle());
        holder.description.setText(post.getDescription());
        holder.author.setText(post.getAuthor());
        //holder.imgUrl.setImageURI(Uri.parse(post.getImgUrl()));
        Picasso.get().load(post.getImgUrl()).into(holder.imgUrl);
    }

    @NonNull
    @Override
    public PastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post, parent, false);
        return new PastViewHolder(view);
    }

    class PastViewHolder extends RecyclerView.ViewHolder{

        TextView mobile,title,description,author;
        ImageView imgUrl;

        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
            mobile = itemView.findViewById(R.id.mobile);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            author = itemView.findViewById(R.id.author);
            imgUrl = itemView.findViewById(R.id.imgurl);
        }
    }
}
