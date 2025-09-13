package com.example.calculadora;

import static java.lang.String.valueOf;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class CalculaActivity2 extends AppCompatActivity implements View.OnClickListener {
    private String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcula2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btVoltar = findViewById(R.id.btVoltar4);
        btVoltar.setOnClickListener(this);

        Button btCalcular = findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(this);

        TextView tvTitulo = findViewById(R.id.tvTitulo);

        String titulo = getIntent().getStringExtra("operacao");
        operacao = titulo;
        tvTitulo.setText(titulo.concat(" Números"));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btVoltar4) {
            finish();
        } else if (view.getId() == R.id.btCalcular) {
            calcular();
        }
    }
    private void calcular() {
        EditText etNumero1 = findViewById(R.id.etNumero1);
        EditText etNumero2 = findViewById(R.id.etNumero2);

        int n1 = Integer.parseInt(etNumero1.getText().toString());
        int n2 = Integer.parseInt(etNumero2.getText().toString());

        int resultado = 0;

        switch (operacao) {
            case "Somar":
                resultado = n1 + n2;
                break;
            case "Subtrair":
                resultado = n1 - n2;
                break;
            case "Multiplicar":
                resultado = n1 * n2;
                break;
            case "Dividir":
                resultado = n1 / n2;

        }

        Toast.makeText(CalculaActivity2.this, "Resultado: ".concat(valueOf(resultado)),
                        Toast.LENGTH_LONG)
                .show();
       }
    }



