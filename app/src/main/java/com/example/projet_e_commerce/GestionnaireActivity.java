package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GestionnaireActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionnaire);







    }

    public void pageAjouterCommercant(View v){
        Intent intent = new Intent(GestionnaireActivity.this,AjouterCommercantActivity.class);
        startActivity(intent);
    }

    public void pageSupprimerCommercant(View v){
        Intent intent = new Intent(GestionnaireActivity.this,SupprimerCommercantActivity.class);
        startActivity(intent);
    }

    public void retourConnexion(View v){
        Intent intent = new Intent(this, ConnexionGestionnaireActivity.class);
        startActivity(intent);
    }


}