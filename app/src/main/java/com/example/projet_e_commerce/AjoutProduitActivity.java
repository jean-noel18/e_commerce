package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutProduitActivity extends AppCompatActivity {
    public String pseudo_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_produit);
        // Recuperer les intent: le pseudo de celui connecter
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("pseudo_intent")){
                pseudo_intent = intent.getStringExtra("pseudo_intent");
            }
        }

        Button boutonAjout = findViewById(R.id.buttonAjouterProduit);
        final EditText champCategorie = findViewById(R.id.champCategorieProduit);
        final EditText champPrix = findViewById(R.id.champPrixProduit);
        final EditText champNom = findViewById(R.id.champNomProduit);
        final EditText champDescription = findViewById(R.id.champDescriptionProduit);
        final EditText champPromo = findViewById(R.id.champPromoProduit);
        DAOproduit dao = new DAOproduit();


        boutonAjout.setOnClickListener(v -> {

            Produit p = new Produit(champCategorie.getText().toString(),
                    champNom.getText().toString(),
                    champPrix.getText().toString(),
                    champDescription.getText().toString(),champPromo.getText().toString(),pseudo_intent
            );


            dao.add(p).addOnSuccessListener(suc -> {
                Toast.makeText(this, "Nouveau produit ajouté", Toast.LENGTH_SHORT).show();
                retourListeProduit(v);
            }).addOnFailureListener(er -> {
                Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });

    }

    public void retourListeProduit(View v){
        Intent intent = new Intent(this, CommercantActivity.class);
        startActivity(intent);
    }
}