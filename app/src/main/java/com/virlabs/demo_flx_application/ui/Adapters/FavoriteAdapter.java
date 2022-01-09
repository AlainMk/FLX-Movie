package com.virlabs.demo_flx_application.ui.Adapters;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;
import com.virlabs.demo_flx_application.R;
import com.virlabs.demo_flx_application.model.Favorite;
import com.virlabs.demo_flx_application.ui.activities.MovieActivity;
import com.virlabs.demo_flx_application.ui.activities.SerieActivity;

import java.util.ArrayList;
import java.util.List;


public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteViewHolder> {

    private List<Favorite> favorites;
    private final Activity activity;

    public FavoriteAdapter(Activity activity) {
        this.favorites = new ArrayList<>();
        this.activity = activity;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoriteViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_favoris, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        Picasso.with(activity).load(favorites.get(position).getMovie().getImage())
                .placeholder(R.drawable.poster_placeholder)
                .into(holder.image_view_item_poster_image);
        holder.image_view_item_poster_image.setOnClickListener(v -> {
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, holder.image_view_item_poster_image, "imageMain");
            Intent intent = new Intent(activity, MovieActivity.class);

            if (favorites.get(position).getMovie().getType().equals("movie")) {
                intent = new Intent(activity, MovieActivity.class);
            } else if (favorites.get(position).getMovie().getType().equals("serie")) {
                intent = new Intent(activity, SerieActivity.class);
            }

            intent.putExtra("poster", favorites.get(holder.getAdapterPosition()).getMovie());
            activity.startActivity(intent, activityOptionsCompat.toBundle());
        });
    }

    @Override
    public int getItemCount() {
        return favorites.size();
    }

    public void updateData(List<Favorite> favorites) {
        this.favorites = favorites;
        notifyDataSetChanged();
    }
}