package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListeProduitsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produits);
    }


    public void retourCommercant(View v){
        Intent intent = new Intent(this, CommercantActivity.class);
        startActivity(intent);
    }


    public void pageAjoutProduit(View v){
        Intent intent = new Intent(this, AjoutProduitActivity.class);
        startActivity(intent);
    }


}