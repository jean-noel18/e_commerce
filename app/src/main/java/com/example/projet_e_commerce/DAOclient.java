package com.example.projet_e_commerce;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOclient {

    private DatabaseReference databaseReference;

    public DAOclient(){

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Client.class.getSimpleName());
    }

    public Task<Void> add(Client c){


        return databaseReference.push().setValue(c);
    }

    public Task<Void> remove(String key){


        return databaseReference.child(key).removeValue();    }

}
