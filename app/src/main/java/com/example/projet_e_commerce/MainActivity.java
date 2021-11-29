package com.example.projet_e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button boutonGestionnaire;
    Button boutonCommercant;
    Button boutonClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boutonGestionnaire = findViewById(R.id.buttonGestionnaire);
        boutonCommercant = findViewById(R.id.buttonCommercant);
        boutonClient = findViewById(R.id.buttonClient);

        boutonGestionnaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pageConnexion();
            }
        });
    }

    public void pageConnexion(){

        Intent intent = new Intent(this, ConnexionActivity.class);

        /*EditText champDomaine = (EditText) findViewById(R.id.editTextDomaineCompetence);
        String valeurDomaine = champDomaine.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_DOMAINE_COMPETENCE,valeurDomaine);
*/
        startActivity(intent);
    }
}