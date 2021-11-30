package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InscriptionClient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_client);
    }

    public void retourConnexion(View v){
        Intent intent = new Intent(this, ConnexionClientActivity.class);
        startActivity(intent);
    }
}