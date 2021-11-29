package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GestionnaireActivity extends AppCompatActivity {

    Button boutonAjouterCommercant;
    Button boutonSupprCommercant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionnaire);

        boutonAjouterCommercant = findViewById(R.id.buttonAjouterCommercant);
        boutonSupprCommercant = findViewById(R.id.buttonSupprimerCommercant);

        boutonAjouterCommercant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pageAjouterCommercant();

            }
        });


        boutonSupprCommercant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pageSupprimerCommercant();
            }
        });
    }

    public void pageAjouterCommercant(){
        Intent intent = new Intent(GestionnaireActivity.this,AjouterCommercantActivity.class);
        startActivity(intent);
    }

    public void pageSupprimerCommercant(){
        Intent intent = new Intent(GestionnaireActivity.this,SupprimerCommercantActivity.class);
        startActivity(intent);
    }
}