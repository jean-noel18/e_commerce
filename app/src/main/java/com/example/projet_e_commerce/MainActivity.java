package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button boutonSeConnecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boutonSeConnecter = findViewById(R.id.butonConnexion);
        boutonSeConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connexion();
            }
        });


    }
    public void connexion(){
        Intent intent = new Intent(this,ConnexionClientActivity.class);
        startActivity(intent);
    }

    public void acceuil(View view){
        Intent intent = new Intent(this,Acceuil.class);
        startActivity(intent);
    }


}