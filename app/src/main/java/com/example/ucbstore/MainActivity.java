package com.example.ucbstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textNome;
    private EditText textPreco;
    private CheckBox cbImport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialize os componentes da UI
        textNome = findViewById(R.id.textNome);
        textPreco = findViewById(R.id.textPreco);
        cbImport = findViewById(R.id.cbImport);
        Button btSalvar = findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtém o texto dos EditTexts e o estado do CheckBox
                String inputNome = textNome.getText().toString().trim();
                String inputPreco = textPreco.getText().toString().trim();
                boolean isChecked = cbImport.isChecked();

                // Verifica se todos os campos estão preenchidos
                if (inputNome.isEmpty() || inputPreco.isEmpty()) {
                    // Mostra uma mensagem de erro
                    Toast.makeText(MainActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                } else {
                    // Cria uma Intent para iniciar a SegundaActivity
                    Intent intent = new Intent(MainActivity.this, viewcadastro.class);

                    // Adiciona os dados como extras no Intent
                    intent.putExtra("EXTRA_INPUT", inputNome);
                    intent.putExtra("EXTRA_PRECO", inputPreco);
                    intent.putExtra("EXTRA_CHECKBOX_STATE", isChecked);

                    // Inicia a SegundaActivity
                    startActivity(intent);
                }
            }
        });
    }
}
