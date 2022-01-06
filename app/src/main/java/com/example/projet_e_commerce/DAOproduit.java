package com.example.projet_e_commerce;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOproduit {

    private DatabaseReference databaseReference;

    public DAOproduit(){

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Produit.class.getSimpleName());

    }

    public Task<Void> add(Produit p){


        return databaseReference.push().setValue(p);
    }

    public Task<Void> remove(String key){


        return databaseReference.child(key).removeValue();    }

}

