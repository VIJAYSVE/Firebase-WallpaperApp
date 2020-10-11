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

public class WallpaperPostAdapter extends FirebaseRecyclerAdapter<WallpaperPost, WallpaperPostAdapter.PastViewHolder>{
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public WallpaperPostAdapter(@NonNull FirebaseRecyclerOptions options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull WallpaperPostAdapter.PastViewHolder holder, int i, @NonNull WallpaperPost wallpost) {
//        holder.mobile.setText(post.getMobile());
//        holder.title.setText(post.getTitle());
//        holder.description.setText(post.getDescription());
//        holder.author.setText(post.getAuthor());
        //holder.imgUrl.setImageURI(Uri.parse(post.getImgUrl()));
        Picasso.get().load(wallpost.getLink()).into(holder.imgwallUrl);
    }

    @NonNull
    @Override
    public WallpaperPostAdapter.PastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wallpaper_singlepost_grid, parent, false);
        return new PastViewHolder(view);
    }

    class PastViewHolder extends RecyclerView.ViewHolder{

        //TextView mobile,title,description,author;
        ImageView imgwallUrl;

        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
//            mobile = itemView.findViewById(R.id.mobile);
//            title = itemView.findViewById(R.id.title);
//            description = itemView.findViewById(R.id.description);
//            author = itemView.findViewById(R.id.author);
            imgwallUrl = itemView.findViewById(R.id.imgwallurl);
        }
    }
}
