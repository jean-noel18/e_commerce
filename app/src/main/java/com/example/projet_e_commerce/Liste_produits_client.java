package com.example.projet_e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Liste_produits_client extends AppCompatActivity {
    FirebaseRecyclerAdapter adapter;
    RecyclerView recyclerView;
    public String recherche_intent;

    static class ProduitVhh extends RecyclerView.ViewHolder{
        TextView mnom;
        TextView mprix;
        //TextView mdescription;
        public ConstraintLayout produit_item;
        public ProduitVhh(@NonNull View itemView) {
            super(itemView);
            mnom = itemView.findViewById(R.id.nom_textview);
            mprix = itemView.findViewById((R.id.textView2));
            produit_item = (ConstraintLayout) itemView.findViewById((R.id.produit_item));


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produits_client);

        // je recupere les intents:
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("champ_recherche")){
                recherche_intent = intent.getStringExtra("champ_recherche");
            }
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler_produitgg);
        //recyclerView.findViewById(R.id.recycler_produits);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        //Log.e("mon tag xxxxxxxx: ",recherche_intent);
        Query query = ref.child("Produit").orderByChild("nom").equalTo(recherche_intent);
        FirebaseRecyclerOptions<Produit> options;
        options = new FirebaseRecyclerOptions.Builder<Produit>().
                setQuery(query,Produit.class).build();

        adapter = new FirebaseRecyclerAdapter<Produit, ProduitVhh>(options) {

            @NonNull
            @Override
            public ProduitVhh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produits,parent,false);
                return new ProduitVhh(layout);
            }

            @Override
            protected void onBindViewHolder(@NonNull ProduitVhh holder, int position, @NonNull Produit model) {
                holder.mnom.setText(model.getNom());
                holder.mprix.setText(model.getPrix()+"€");
                //holder.mdescription.setText(model.getDescription());
                holder.produit_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        Intent i = new Intent(Liste_produits_client.this,ProduitCommercantActivity.class);
                        i.putExtra("mnom",model.getNom());
                        i.putExtra("mprix",model.getPrix());
                        i.putExtra("mdescription",model.getDescription());
                        startActivity(i);
                    }
                });


            }
        };
        recyclerView.setAdapter(adapter);
    }
    public void retouracc(View v){
        Intent intent = new Intent(this, Acceuil.class);
        startActivity(intent);
    }
    public void recherche (View v){
        EditText champRecherche = findViewById(R.id.champRechercher);
        Intent intent = new Intent(this, Liste_produits_client.class);
        intent.putExtra("champ_recherche",champRecherche.getText().toString());
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}