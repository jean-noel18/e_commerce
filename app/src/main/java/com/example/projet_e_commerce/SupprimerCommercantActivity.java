package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SupprimerCommercantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer_commercant);

        Button boutonSuppr = findViewById(R.id.buttonSupprimerCommercant);
        final EditText champPseudo = findViewById(R.id.editTextSupprimerPseudo);

        DAOcommercant dao = new DAOcommercant();




        boutonSuppr.setOnClickListener(v -> {




            dao.remove(c).addOnSuccessListener(suc -> {
                Toast.makeText(this, "Nouveau commercant ajouté", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er -> {
                Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });

    }

    public void retourMenuGestionnaire(View view) {
        Intent intent = new Intent(this, GestionnaireActivity.class);
        startActivity(intent);
    }
}