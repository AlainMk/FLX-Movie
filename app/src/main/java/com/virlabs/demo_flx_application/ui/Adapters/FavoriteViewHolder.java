package com.virlabs.demo_flx_application.ui.Adapters;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.virlabs.demo_flx_application.R;

public class FavoriteViewHolder extends RecyclerView.ViewHolder {
    ImageView image_view_item_poster_image ;

    public FavoriteViewHolder(@NonNull View itemView) {
        super(itemView);
        this.image_view_item_poster_image = itemView.findViewById(R.id.image_view_item_poster_image);
    }
}
