package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InscriptionClient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_client);

        final EditText champNom = findViewById(R.id.champNom);
        final EditText champPrenom = findViewById(R.id.champPrenom);
        final EditText champPseudo = findViewById(R.id.champPseudo);
        final EditText champMdp = findViewById(R.id.champMdp);
        final EditText champAdresse = findViewById(R.id.champAdresse);
        final EditText champCentreInteret = findViewById(R.id.champCentreInteret);
        Button btnInscription = findViewById(R.id.buttonInscription);
        DAOclient dao = new DAOclient();

        btnInscription.setOnClickListener(v->{

            Client c = new Client(champNom.getText().toString(),
                    champPrenom.getText().toString(),
                    champPseudo.getText().toString(),
                    champMdp.getText().toString(),
                    champAdresse.getText().toString(),
                    champCentreInteret.getText().toString());


            dao.add(c).addOnSuccessListener(suc->{
                Toast.makeText(this, "Inscription validée", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });

          /*  dao.remove("-Msk9UWbrm8UEKJTIreq").addOnSuccessListener(suc->{
                Toast.makeText(this, "Inscription validée", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });*/

        });


    }

    public void retourConnexion(View v){
        Intent intent = new Intent(this, ConnexionClientActivity.class);
        startActivity(intent);
    }
}