package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CommercantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commercant);
    }

    public void retourConnexionCommercant(View v){
        Intent intent = new Intent(this, ConnexionCommercantActivity.class);
        startActivity(intent);
    }
    public void pageListeProduits(View v){
        Intent intent = new Intent(this, ListeProduitsActivity.class);
        startActivity(intent);
    }


    public void pageListeCommande(View v){
        Intent intent = new Intent(this, ListeCommandeActivity.class);
        startActivity(intent);
    }


}