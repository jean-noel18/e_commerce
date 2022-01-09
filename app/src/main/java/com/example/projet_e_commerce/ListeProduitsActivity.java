package com.example.projet_e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class ListeProduitsActivity extends AppCompatActivity {
    FirebaseDatabase db;
    FirebaseRecyclerAdapter adapter;
    RecyclerView recyclerView;
    public String pseudo_intent;


    class ProduitVh extends RecyclerView.ViewHolder{
        TextView mnom;
        TextView mprix;
        //TextView mdescription;
        public ConstraintLayout produit_item;
        public ProduitVh(@NonNull View itemView) {
            super(itemView);
            mnom = itemView.findViewById(R.id.nom_textview);
            mprix = itemView.findViewById((R.id.textView2));
            produit_item = (ConstraintLayout) itemView.findViewById((R.id.produit_item));


        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produits);

        // Recuperer les intent: le pseudo de celui connecter
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("pseudo_intent")){
                pseudo_intent = intent.getStringExtra("pseudo_intent");
            }
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler_produits);
        //recyclerView.findViewById(R.id.recycler_produits);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        db = FirebaseDatabase.getInstance();
        //CollectionReference ref  = db.getReference("Produit");
        Query query = db.getReference().child("Produit").orderByChild("nom");
        FirebaseRecyclerOptions<Produit> options;
        options = new FirebaseRecyclerOptions.Builder<Produit>().
                setQuery(query,Produit.class).build();

        adapter = new FirebaseRecyclerAdapter<Produit,ProduitVh>(options) {

            @NonNull
            @Override
            public ProduitVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produits,parent,false);
                return new ProduitVh(layout);
            }

            @Override
            protected void onBindViewHolder(@NonNull ProduitVh holder, int position, @NonNull Produit model) {
                holder.mnom.setText(model.getNom());
                holder.mprix.setText(model.getPrix()+"€");
                //holder.mdescription.setText(model.getDescription());
                holder.produit_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        Intent i = new Intent(ListeProduitsActivity.this,ProduitCommercantActivity.class);
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


    public void retourCommercant(View v){
        Intent intent = new Intent(this, CommercantActivity.class);
        startActivity(intent);
    }


    public void pageAjoutProduit(View v){
        Intent intent = new Intent(this, AjoutProduitActivity.class);
        intent.putExtra("pseudo_intent", pseudo_intent);
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