package com.example.projet_e_commerce;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOcommercant {

    private DatabaseReference databaseReference;

    public DAOcommercant(){

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Commercant.class.getSimpleName());

    }

    public Task<Void> add(Commercant c){


        return databaseReference.push().setValue(c);
    }

    public Task<Void> remove(String key){


        return databaseReference.child(key).removeValue();    }

}
