package com.example.calculadora;

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

public class ViagemActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResultado;

    //1. Configuração Inicial da Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_viagem);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btVoltar4), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //2. Vinculação dos Botões e Listeners
        Button btVoltar2 = findViewById(R.id.btVoltar2);
        btVoltar2.setOnClickListener(this);

        Button btConsulta = findViewById(R.id.btConsulta);
        btConsulta.setOnClickListener(this);

        Button btCalcular2 = findViewById(R.id.btCalcular2);
        btCalcular2.setOnClickListener(this);

        // Vincular o TextView de resultado
        tvResultado = findViewById(R.id.tvResultado);
    }

    //3. Tratamento de Cliques (onClick)
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btVoltar2) {
            finish(); // Fecha a Activity e volta para a tela anterior
        } else if (view.getId() == R.id.btConsulta) {
            limparCampos(); // Limpa os campos de entrada
        } else if (view.getId() == R.id.btCalcular2) {
            calcularViagem(); // Executa os cálculos
        }
    }

    //4. Cálculo da Viagem
    private void calcularViagem() {

        // Obtém referências dos EditTexts
        EditText etDistancia = findViewById(R.id.etDistancia);
        EditText etValor = findViewById(R.id.etValor);
        EditText etMedia = findViewById(R.id.etMedia);

        // Verifica se os campos estão preenchidos
        if (etDistancia.getText().toString().isEmpty() ||
           etValor.getText().toString().isEmpty() ||
           etMedia.getText().toString().isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;

        }

        // Converte textos para double
        try {
            double distancia = Double.parseDouble(etDistancia.getText().toString());
            double valorLitro = Double.parseDouble(etValor.getText().toString());
            double mediaKmLitro = Double.parseDouble(etMedia.getText().toString());

            // Execução dos Cálculos
            double litrosConsumidos = distancia / mediaKmLitro;
            double custoTotal = litrosConsumidos * valorLitro;

            // Exibir resultados no TextView
            String mensagem = String.format(
                    "Litros consumidos: %.2f\nCusto total da viagem: R$ %.2f",
                    litrosConsumidos,
                    custoTotal
            );

            tvResultado.setText(mensagem);

           // Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Valores inválidos!", Toast.LENGTH_SHORT).show();
        }
    }

    //5. Limpeza dos Campos (limparCampos)

    private void limparCampos() {
        EditText etDistancia = findViewById(R.id.etDistancia);
        EditText etValor = findViewById(R.id.etValor);
        EditText etMedia = findViewById(R.id.etMedia);

        etDistancia.setText("");   //Limpa o conteúdo dos EditTexts.
        etValor.setText("");
        etMedia.setText("");
        etDistancia.requestFocus(); // Coloca o cursor no campo de distância para nova digitação.

        tvResultado.setText("");   // limpa também o resultado
    }
}