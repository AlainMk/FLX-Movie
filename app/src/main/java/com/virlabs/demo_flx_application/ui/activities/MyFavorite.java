package com.virlabs.demo_flx_application.ui.activities;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.virlabs.demo_flx_application.R;
import com.virlabs.demo_flx_application.Utils.SpacesItemDecoration;
import com.virlabs.demo_flx_application.api.FavoriteHelper;
import com.virlabs.demo_flx_application.model.Favorite;
import com.virlabs.demo_flx_application.ui.Adapters.FavoriteAdapter;

import java.util.List;

public class MyFavorite extends BaseActivity {

    RecyclerView recyclerView;

    private FavoriteAdapter favoriteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favorite);
        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.my_favorite));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_view);
        configureRecyclerView();
        getFavorites();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        return;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Respond to the action bar's Up/Home button
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getFavorites() {
        FavoriteHelper.getUserFavorites(getCurrentUser().getUid()).addSnapshotListener((queryDocumentSnapshots, e) -> {
            if (queryDocumentSnapshots != null) {
                List<Favorite> favoriteList = queryDocumentSnapshots.toObjects(Favorite.class);
                this.updateItemsList(favoriteList);
            }
        });
    }

    private void configureRecyclerView() {

        this.favoriteAdapter = new FavoriteAdapter(this);

        this.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new SpacesItemDecoration(5));
        recyclerView.setAdapter(this.favoriteAdapter);
    }

    // 6 - Update the list of items
    private void updateItemsList(List<Favorite> favorites){

        this.favoriteAdapter.updateData(favorites);
    }
}