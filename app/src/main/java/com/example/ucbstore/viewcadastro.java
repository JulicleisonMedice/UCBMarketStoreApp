package com.example.ucbstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class viewcadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcadastro);

        // Inicialize o TextView para exibir as informações
        TextView textViewNome = findViewById(R.id.textProduto);
        TextView textViewPreco = findViewById(R.id.textView5);
        TextView textViewImport = findViewById(R.id.textView8);
        Button btVoltar = findViewById(R.id.btVoltar);

        // Obtém o Intent que iniciou esta Activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // Recupera os dados do Intent
            String inputNome = extras.getString("EXTRA_INPUT");
            String inputPreco = extras.getString("EXTRA_PRECO");
            boolean isChecked = extras.getBoolean("EXTRA_CHECKBOX_STATE");

            // Define o texto nos TextViews
            textViewNome.setText(inputNome);
            textViewPreco.setText(inputPreco);
            textViewImport.setText((isChecked ? "Sim" : "Não"));
        }

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fecha a SegundaActivity e retorna à MainActivity
                finish();
            }
        });
    }
}
