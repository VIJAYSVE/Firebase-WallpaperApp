package com.aio.firebasethirdsample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class UserAdapter extends FirebaseRecyclerAdapter<UserHelperClass, UserAdapter.UserViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public UserAdapter(@NonNull FirebaseRecyclerOptions<UserHelperClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull UserViewHolder holder, int position, @NonNull UserHelperClass helper) {
        holder.nameitem.setText(helper.getName());
        holder.genderitem.setText(helper.getGender());
        holder.ageitem.setText(helper.getAge());
        holder.mobileitem.setText(helper.getMobile());
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_item, parent, false);

        return new UserViewHolder(view);
    }

    //UserViewHolder Class
    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView nameitem, genderitem, ageitem, mobileitem;
            public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nameitem = itemView.findViewById(R.id.nameitem);
            genderitem = itemView.findViewById(R.id.genderitem);
            ageitem = itemView.findViewById(R.id.ageitem);
            mobileitem = itemView.findViewById(R.id.mobileitem);

        }
    }
}
