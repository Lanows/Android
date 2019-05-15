package com.example.projetoheadsup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaModo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_modo);

        Button btnFacil = (Button) findViewById(R.id.btnFacil);
        Button btnNormal = (Button) findViewById(R.id.btnNormal);
        Button btnDificil = (Button) findViewById(R.id.btnDificil);
        Button btnPersonalizado = (Button) findViewById(R.id.btnPersonalizado);

        btnFacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(TelaModo.this, TelaJogo.class);
                startActivity(next);
            }
        });
    }
}
