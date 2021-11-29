package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConnexionCommercantActivity extends AppCompatActivity {

    Button bouttonClient;
    Button bouttonGestionnaire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_commercant);

        bouttonClient = findViewById(R.id.bouttonClient);
        bouttonGestionnaire = findViewById(R.id.bouttonGestionnaire);
        bouttonGestionnaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnexionGestionnaire();
            }
        });



        bouttonClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnexionClient();
            }
        });

    }

    public void ConnexionClient(){
        Intent intent = new Intent(this,ConnexionClientActivity.class);
        startActivity(intent);
    }

    public void ConnexionGestionnaire(){
        Intent intent = new Intent(this,ConnexionGestionnaireActivity.class);
        startActivity(intent);
    }
    public void retourAccueil(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}