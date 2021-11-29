package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConnexionClientActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_client);
    }

    public void connexionGestionnaire(View v){
        Intent intent = new Intent(this,ConnexionGestionnaireActivity.class);
        startActivity(intent);
    }

    public void connexionCommercant(View v){
        Intent intent = new Intent(this, ConnexionCommercantActivity.class);
        startActivity(intent);
    }
    public void retourAccueil(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}