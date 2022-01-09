package com.virlabs.demo_flx_application.api;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.virlabs.demo_flx_application.model.Favorite;

public class FavoriteHelper {

    private static final String COLLECTION_NAME = "favorites";

    // --- COLLECTION REFERENCE ---

    public static CollectionReference getCollectionReference(){
        return FirebaseFirestore.getInstance().collection(COLLECTION_NAME);
    }

    public static Query getUserFavorites(String user){
        return FirebaseFirestore.getInstance().collection(COLLECTION_NAME).whereEqualTo("user", user);
    }

    // --- CREATE ---

    public static Task<Void> createFavorite(Favorite favorite) {
        return getCollectionReference().document(favorite.getId()).set(favorite);
    }

    public static Task<Void> removeFavorite(String id) {
        return getCollectionReference().document(id).delete();
    }
}
