package com.example.calculadordesalario3000;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText etSalario;
    RadioGroup rgEscolha;
    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSalario = findViewById(R.id.etQuest1);
        rgEscolha = findViewById(R.id.rg1);
        btCalcular = findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etSalario.getText().toString().equals("")) {
                    double salario = Double.parseDouble(etSalario.getText().toString());
                    int op = rgEscolha.getCheckedRadioButtonId();
                    double novoSalario = 0;

                    if (op == R.id.rb1) {
                        novoSalario = salario * 1.40;
                    } else if (op == R.id.rb2) {
                        novoSalario = salario * 1.45;
                    } else {
                        novoSalario = salario * 1.5;
                    }

                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("Novo Salário!");
                    dialogo.setMessage("Seu novo salário é: R$" + novoSalario);
                    dialogo.setNeutralButton("ok", null);
                    dialogo.show();
                }else {
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("Erro!");
                    dialogo.setMessage("Campos em branco");
                    dialogo.setNeutralButton("ok", null);
                    dialogo.show();
                }
            }
        });
    }
}