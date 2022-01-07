package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutProduitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_produit);

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
                    champDescription.getText().toString(),champPromo.getText().toString()
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
        Intent intent = new Intent(this, ListeProduitsActivity.class);
        startActivity(intent);
    }
}