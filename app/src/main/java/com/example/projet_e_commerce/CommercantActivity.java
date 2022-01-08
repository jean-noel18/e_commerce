package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class CommercantActivity extends AppCompatActivity {
    public String pseudo_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commercant);

        // Recuperer les intent: le pseudo de celui connecter
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("pseudo_intent")){
                pseudo_intent = intent.getStringExtra("pseudo_intent");
                //Log.i("testons:",pseudo_intent);

            }
        }
    }

    public void retourConnexionCommercant(View v){
        Intent intent = new Intent(this, ConnexionCommercantActivity.class);
        startActivity(intent);
    }
    public void pageListeProduits(View v){
        Intent intent = new Intent(this, ListeProduitsActivity.class);
        intent.putExtra("pseudo_intent", pseudo_intent);
        startActivity(intent);
    }


    public void pageListeCommande(View v){
        Intent intent = new Intent(this, ListeCommandeActivity.class);
        startActivity(intent);
    }


}