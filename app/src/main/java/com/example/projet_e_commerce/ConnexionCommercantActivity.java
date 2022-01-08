package com.example.projet_e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class ConnexionCommercantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_commercant);

        final EditText psd = findViewById(R.id.editTextPseudoCommercant);
        final EditText password = findViewById(R.id.editTextMotDePasseCommercant);
        Button connexion = findViewById(R.id.buttonSeConnecterCommercant);

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                Query applesQuery = ref.child("Commercant").orderByChild("pseudo").equalTo(psd.getText().toString());

                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                            String  mdp = appleSnapshot.child("mdp").getValue().toString();

                            if(mdp.equals(password.getText().toString())){
                                //pageCommercant(view);
                                Intent intent = new Intent(ConnexionCommercantActivity.this,CommercantActivity.class);
                                intent.putExtra("pseudo_intent", psd.getText().toString());
                                startActivity(intent);
                            }else{
                               // Toast.makeText(this, "identifiant ou mot de passe incorect", Toast.LENGTH_SHORT).show();

                            }


                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }


                });
            }
        });



    }


    public void pageCommercant(View view){
        Intent intent = new Intent(this,CommercantActivity.class);
        startActivity(intent);
    }

    public void retourAccueil(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void pageConnexionGestionnaire(View v){
        Intent intent = new Intent(this, ConnexionGestionnaireActivity.class);
        startActivity(intent);
    }

    public void pageConnexionClient(View v){
        Intent intent = new Intent(this, ConnexionClientActivity.class);
        startActivity(intent);
    }


}