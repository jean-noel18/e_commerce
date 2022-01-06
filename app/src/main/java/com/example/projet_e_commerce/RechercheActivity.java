package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RechercheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);

        Intent intent = getIntent();


        String message_categorie = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_CATEGORIE);
        String message_description = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_DESCRIPTION);
        String message_nom = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_NOM);
        String message_prix = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_PRIX);
        String message_promo = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_PROMO);

        TextView zoneRecherche = findViewById(R.id.zoneRecherche);
        zoneRecherche.setText(message_categorie);

    }
}