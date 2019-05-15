package com.example.projetoheadsup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_menu);

        Button btnIniciar = (Button) findViewById(R.id.btnIniciar);
        Button btnConfig = (Button) findViewById(R.id.btnConfig);
        Button btnInfo = (Button) findViewById(R.id.btnInfo);
        Button btnSair = (Button) findViewById(R.id.btnSair);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(TelaMenu.this, TelaModo.class);
                startActivity(next);
            }
        });

        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(TelaMenu.this, TelaConfig.class);
                startActivity(next);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(TelaMenu.this, TelaInfo.class);
                startActivity(next);
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(TelaMenu.this, MainActivity.class);
                startActivity(next);
            }
        });
    }
}
