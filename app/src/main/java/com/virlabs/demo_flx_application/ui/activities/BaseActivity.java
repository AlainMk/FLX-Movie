package com.virlabs.demo_flx_application.ui.activities;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BaseActivity extends AppCompatActivity {

    // --------------------
    // UTILS
    // --------------------

    @Nullable
    protected FirebaseUser getCurrentUser(){ return FirebaseAuth.getInstance().getCurrentUser(); }

    protected Boolean isCurrentUserLogged(){ return (this.getCurrentUser() != null); }


    // --------------------
    // ERROR HANDLER
    // --------------------

    protected OnFailureListener onFailureListener(){
        return e -> Toast.makeText(getApplicationContext(), "Une erreur inconnue s'est produite", Toast.LENGTH_LONG).show();
    }
}
