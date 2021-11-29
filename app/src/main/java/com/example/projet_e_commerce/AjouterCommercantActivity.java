package com.example.projet_e_commerce;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjouterCommercantActivity extends AppCompatActivity {

    Button boutonAjout;
    EditText champNouveauPseudo;
    EditText champNouveauMdp;
    EditText champNouveauMdpDeuxiemeSaisie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_commercant);

        boutonAjout = findViewById(R.id.buttonAjouterCommercant);
        champNouveauPseudo = findViewById(R.id.editTextAjoutPseudo);
        champNouveauMdp = findViewById(R.id.editTextAjoutNouveauMdp);
        champNouveauMdpDeuxiemeSaisie = findViewById(R.id.editTextAjoutDeuxiemeSaisieMdp);


        boutonAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(champNouveauMdp.getText().toString().equals("")){
                    Toast.makeText(AjouterCommercantActivity.this, "Remplissez tous les champs", Toast.LENGTH_LONG).show();

                }else if(champNouveauMdp.getText().toString().equals(champNouveauMdpDeuxiemeSaisie.getText().toString())){

                    AlertDialog.Builder fenetreDeDialogue = new AlertDialog.Builder(AjouterCommercantActivity.this);
                    fenetreDeDialogue.setTitle("Validation");
                    fenetreDeDialogue.setMessage("Voulez-vous vraiment ajouter ce nouveau commercant : "+champNouveauPseudo.getText().toString()+
                            ", avec le mot de passe : "+champNouveauMdp.getText().toString()+" ?");

                    fenetreDeDialogue.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent intent = new Intent(AjouterCommercantActivity.this,GestionnaireActivity.class);
                            startActivity(intent);
                            Toast.makeText(AjouterCommercantActivity.this, "Nouveau commercant ajouté avec succes", Toast.LENGTH_LONG).show();


                        }
                    });

                    fenetreDeDialogue.setNegativeButton("Non",null);
                    fenetreDeDialogue.show();


                }else{
                    Toast.makeText(AjouterCommercantActivity.this, "Les mots de passe de correspondent pas.", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    public void retourAjoutSuppr(View view) {
        Intent intent = new Intent(this, GestionnaireActivity.class);
        startActivity(intent);
    }
}