package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConnexionGestionnaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_gestionnaire);
    }
    public void connexionClien(View v){
        Intent intent = new Intent(this,ConnexionClientActivity.class);
        startActivity(intent);
    }

    public void connexionCommercant(View v){
        Intent intent = new Intent(this,ConnexionCommercantActivity.class);
        startActivity(intent);
    }
    public void retourAccueil(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}