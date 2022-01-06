package com.example.projet_e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Acceuil extends AppCompatActivity {

    public static final String EXTRA_MESSAGE_CATEGORIE= "com.example.myapplication.MESSAGE_CATEGORIE";
    public static final String EXTRA_MESSAGE_DESCRIPTION= "com.example.myapplication.MESSAGE_DESCRIPTION";
    public static final String EXTRA_MESSAGE_NOM= "com.example.myapplication.MESSAGE_NOM";
    public static final String EXTRA_MESSAGE_PRIX= "com.example.myapplication.MESSAGE_PRIX";
    public static final String EXTRA_MESSAGE_PROMO= "com.example.myapplication.MESSAGE_PROMO";

    String categorie;
    String description;
    String nom;
    String prix ;
    String promo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        final EditText champRecherche = findViewById(R.id.champRecherche);
        Button rech = findViewById(R.id.rech);

        rech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                Query applesQuery = ref.child("Produit").orderByChild("description").equalTo(champRecherche.getText().toString());

                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                             categorie = appleSnapshot.child("categorie").getValue().toString();
                             description = appleSnapshot.child("description").getValue().toString();
                             nom = appleSnapshot.child("nom").getValue().toString();
                             prix = appleSnapshot.child("prix").getValue().toString();
                             promo = appleSnapshot.child("promo").getValue().toString();
                            System.out.println(categorie);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }


                });
                pageRecherche();
            }
        });


    }

    public void r(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void pageRecherche(){

        Intent intent = new Intent(this, RechercheActivity.class);

          intent.putExtra(EXTRA_MESSAGE_CATEGORIE,categorie);
        intent.putExtra(EXTRA_MESSAGE_DESCRIPTION,description);
        intent.putExtra(EXTRA_MESSAGE_NOM,nom);
        intent.putExtra(EXTRA_MESSAGE_PRIX,prix);
        intent.putExtra(EXTRA_MESSAGE_PROMO,promo);








        startActivity(intent);
    }
}