package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ConnexionGestionnaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_gestionnaire);
    }
    public void connexionClien(){
        Intent intent = new Intent(this,ConnexionClientActivity.class);
        startActivity(intent);
    }

    public void connexionCommercant(){
        Intent intent = new Intent(this,ConnexionCommercantActivity.class);
        startActivity(intent);
    }
}