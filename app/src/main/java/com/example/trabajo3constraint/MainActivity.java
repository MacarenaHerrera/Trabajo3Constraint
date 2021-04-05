package com.example.trabajo3constraint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private int flag = 0;
    private TextView monedaUno, monedaDos;
    private EditText etValorD, etValorE;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monedaUno = findViewById(R.id.tvMoneda1);
        monedaDos = findViewById(R.id.tvMoneda2);
        etValorD = findViewById(R.id.etValorD);
        etValorE = findViewById(R.id.etValorE);
        etValorD.setEnabled(false);
        etValorE.setEnabled(false);
        tvResultado = findViewById(R.id.tvResultado);
    }

    public void rbClicked(View view) {
        etValorE.setText("");
        etValorD.setText("");
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rbDolares:
                if (checked)
                    etValorD.setFocusable(true);
                    etValorD.setEnabled(true);
                    etValorE.setEnabled(false);
                    etValorE.setText("");
                    tvResultado.setText("");
                flag = 1;
                break;
            case R.id.rbEuros:
                if (checked)
                    etValorE.setFocusable(true);
                    etValorE.setEnabled(true);
                    etValorD.setEnabled(false);
                    etValorD.setText("");
                    tvResultado.setText("");
                flag = 2;
                break;
        }
    }

    public void convertir(View v) {
        double valor;
        double resultado;
        String signo;
        DecimalFormat format = new DecimalFormat("#.00");
        String moneda1 = etValorD.getText().toString();
        String moneda2 = etValorE.getText().toString();

        if (flag == 1) {
            if (moneda1.isEmpty()) {
                Toast.makeText(this, "Ingrese dólares a cambiar", Toast.LENGTH_LONG).show();
            } else {
                valor = Double.parseDouble(etValorD.getText().toString());
                resultado = valor * 0.85;
                signo = "€";
                String resString = signo + format.format(resultado);
                tvResultado.setText(resString);
            }
        } else {
            if (moneda2.isEmpty()) {
                Toast.makeText(this, "Ingrese euros a cambiar", Toast.LENGTH_LONG).show();
            } else {
                valor = Double.parseDouble(etValorE.getText().toString());
                resultado = valor * 1.18;
                signo = "u$s";
                String resString = signo + format.format(resultado);
                tvResultado.setText(resString);
            }
        }
        etValorD.setEnabled(false);
        etValorE.setEnabled(false);

    }
}