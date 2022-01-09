package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProduitCommercantActivity extends AppCompatActivity {
    public TextView mnom;
    public TextView mprix;
    public TextView mdescription;
    public TextView mnom2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit_commercant);

        mnom = findViewById(R.id.nom_produit);
        mnom2 = findViewById(R.id.nom_produititem);
        mprix = findViewById(R.id.Prix_produit);
        mdescription = findViewById(R.id.description_item);


        // Recuperation des données avec intent
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("mnom")){
                mnom.setText(intent.getStringExtra("mnom"));
                mnom2.setText(intent.getStringExtra("mnom"));
            }
            if (intent.hasExtra("mprix")){
                mprix.setText("Prix: "+intent.getStringExtra("mprix")+"€");
            }
            if (intent.hasExtra("mdescription")){
                mdescription.setText("Description: "+intent.getStringExtra("mdescription"));
            }
        }
    }
}