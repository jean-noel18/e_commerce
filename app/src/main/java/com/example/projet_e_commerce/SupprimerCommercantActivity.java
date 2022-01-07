package com.example.projet_e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SupprimerCommercantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer_commercant);

        Button boutonSuppr = findViewById(R.id.buttonSupprimerCommercant);
        final EditText champPseudo = findViewById(R.id.editTextSupprimerPseudo);

        DAOcommercant dao = new DAOcommercant();




        boutonSuppr.setOnClickListener(v -> {

         /* dao.remove("-Msk9UWbrm8UEKJTIreq").addOnSuccessListener(suc->{
                Toast.makeText(this, "Inscription validée", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });*/

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
            Query applesQuery = ref.child("Commercant").orderByChild("pseudo").equalTo(champPseudo.getText().toString());

            applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                        appleSnapshot.getRef().removeValue();
                        Toast.makeText(getApplicationContext(), "Commercant supprimé", Toast.LENGTH_LONG).show();

                        retourMenuGestionnaire(v);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });


        });

    }

    public void retourMenuGestionnaire(View view) {
        Intent intent = new Intent(this, GestionnaireActivity.class);
        startActivity(intent);
    }
}