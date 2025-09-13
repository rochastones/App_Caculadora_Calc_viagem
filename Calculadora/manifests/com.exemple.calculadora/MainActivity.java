package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btCalculadora = findViewById(R.id.btCalculadora);
        btCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a tela Home
                Intent telaHome = new Intent(MainActivity.this, HomeActivity2.class);
                startActivity(telaHome);
                //finish();
            }
        });

        // inclusão do Botão Viagem
        Button btViagem = findViewById(R.id.btViagem);
        btViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaViagem = new Intent(MainActivity.this, ViagemActivity.class);
                startActivity(telaViagem);
                //finish();
            }
        });

    }
}