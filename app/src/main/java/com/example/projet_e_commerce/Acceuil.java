package com.example.projet_e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Acceuil extends AppCompatActivity {

    public static final String EXTRA_MESSAGE_CATEGORIE= "com.example.projet_e_commerce.MESSAGE_CATEGORIE";
    public static final String EXTRA_MESSAGE_DESCRIPTION= "com.example.projet_e_commerce.MESSAGE_DESCRIPTION";
    public static final String EXTRA_MESSAGE_NOM= "com.example.projet_e_commerce.MESSAGE_NOM";
    public static final String EXTRA_MESSAGE_PRIX= "com.example.projet_e_commerce.MESSAGE_PRIX";
    public static final String EXTRA_MESSAGE_PROMO= "com.example.projet_e_commerce.MESSAGE_PROMO";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        final EditText champRecherche = findViewById(R.id.champRecherche);
        Button rech = findViewById(R.id.rech);



        rech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Acceuil.this, Liste_produits_client.class);
                intent.putExtra("champ_recherche",champRecherche.getText().toString());
                startActivity(intent);
                /*DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                Query applesQuery = ref.child("Produit").orderByChild("nom").equalTo(champRecherche.getText().toString());
                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                           String  categorie = appleSnapshot.child("categorie").getValue().toString();
                            String description = appleSnapshot.child("description").getValue().toString();
                            String nom = appleSnapshot.child("nom").getValue().toString();
                            String prix = appleSnapshot.child("prix").getValue().toString();
                            String promo = appleSnapshot.child("promo").getValue().toString();
                            System.out.println(categorie);
                            System.out.println(description);
                            System.out.println(nom);
                            System.out.println(prix);
                            System.out.println(promo);
                            pageRecherche(categorie,description,nom,prix,promo);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }


                });*/
            }
        });


    }

    public void r(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void pageRecherche(String categorie, String description, String nom, String prix, String promo){

        Intent intent = new Intent(this, RechercheActivity.class);

          intent.putExtra(EXTRA_MESSAGE_CATEGORIE,categorie);
        intent.putExtra(EXTRA_MESSAGE_DESCRIPTION,description);
        intent.putExtra(EXTRA_MESSAGE_NOM,nom);
        intent.putExtra(EXTRA_MESSAGE_PRIX,prix);
        intent.putExtra(EXTRA_MESSAGE_PROMO,promo);








        startActivity(intent);
    }
}