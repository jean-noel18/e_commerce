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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_commercant);

        Button boutonAjout = findViewById(R.id.buttonAjouterCommercant);
        final EditText champPseudo = findViewById(R.id.champPseudoCommercant);
        final EditText champMdp = findViewById(R.id.champMdpCommercant);
        final EditText champNom = findViewById(R.id.champNomCommercant);
        final EditText champPrenom = findViewById(R.id.champPrenomCommercant);
        DAOcommercant dao = new DAOcommercant();




        boutonAjout.setOnClickListener(v -> {

            Commercant c = new Commercant(champNom.getText().toString(),
                    champPrenom.getText().toString(),
                    champPseudo.getText().toString(),
                    champMdp.getText().toString()
                    );


            dao.add(c).addOnSuccessListener(suc -> {
                Toast.makeText(this, "Nouveau commercant ajouté", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er -> {
                Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
    }


    public void retourAjoutSuppr(View view) {
        Intent intent = new Intent(this, GestionnaireActivity.class);
        startActivity(intent);
    }
}



/*boutonAjout.setOnClickListener(new View.OnClickListener() {
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
        });*/