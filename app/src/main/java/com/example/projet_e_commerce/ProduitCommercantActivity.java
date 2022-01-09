package com.example.projet_e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ProduitCommercantActivity extends AppCompatActivity {
    public TextView mnom;
    public TextView mprix;
    public TextView mdescription;
    public TextView mnom2;
    public String pseudo_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit_commercant);

        mnom = findViewById(R.id.nom_produit);
        mnom2 = findViewById(R.id.nom_produititem);
        mprix = findViewById(R.id.Prix_produit);
        mdescription = findViewById(R.id.description_item);

        Button boutonSuppr = findViewById(R.id.buttonSupprProd);



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
            pseudo_intent = intent.getStringExtra("pseudo_intent");

        }


        boutonSuppr.setOnClickListener(v -> {
            Intent intentt = getIntent();
         /* dao.remove("-Msk9UWbrm8UEKJTIreq").addOnSuccessListener(suc->{
                Toast.makeText(this, "Inscription validée", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });*/

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
            Query applesQuery = ref.child("Produit").orderByChild("nom").equalTo(intentt.getStringExtra("mnom").toString());

            applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                        appleSnapshot.getRef().removeValue();
                        Toast.makeText(getApplicationContext(), "Produit supprimé", Toast.LENGTH_LONG).show();

                        retourListeProduitActivity(v);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });


        });
    }
    public void supprimerProduit(View v){
        /*
        A faire la methode qui supprime le produit...
         */
        Intent intent = new Intent(this, ListeProduitsActivity.class);
        startActivity(intent);
    }

    public void retourListeProduitActivity(View v){
        /*
        A faire la methode qui supprime le produit...
         */
        Intent intent = new Intent(this, ListeProduitsActivity.class);
        intent.putExtra("pseudo_intent", pseudo_intent);

        startActivity(intent);
    }

}