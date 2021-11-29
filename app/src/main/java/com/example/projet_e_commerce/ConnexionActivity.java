package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConnexionActivity extends AppCompatActivity {


    EditText champPseudo;
    EditText champMdp;
    Button seConnecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        champPseudo = findViewById(R.id.editTextPseudo);
        champMdp = findViewById(R.id.editTextMotDePasse);
        seConnecter = findViewById(R.id.buttonSeConnecter);

        seConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(champPseudo.getText().toString().equals("admin") &&
                        champPseudo.getText().toString().equals("admin")){

                    Intent intent = new Intent(ConnexionActivity.this,GestionnaireActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(ConnexionActivity.this, "Pseudo ou mot de passe incorrect.", Toast.LENGTH_LONG).show();

                }


            }
        });


    }
}