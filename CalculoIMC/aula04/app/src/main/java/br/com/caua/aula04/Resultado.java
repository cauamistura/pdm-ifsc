package br.com.caua.aula04;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends MainActivity{
        private TextView lbIMC;
        private ImageView igmResult ;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.resultado);

            lbIMC = findViewById(R.id.lbImc);
            igmResult = findViewById(R.id.imgResult);

            Bundle bundle = getIntent().getExtras();
            double imc = bundle.getDouble("imc");

            if (imc < 18.5) {
                lbIMC.setText("IMC: " + String.format("%.2f", imc) + " | Abaixo do peso");
                igmResult.setImageResource(R.drawable.abaixopeso);
            } else if (imc >= 18.5 && imc <= 24.9) {
                lbIMC.setText("IMC: " + String.format("%.2f", imc) + " | Peso normal");
                igmResult.setImageResource(R.drawable.normal);
            } else if (imc >= 25 && imc < 29.9) {
                lbIMC.setText("IMC: " + String.format("%.2f", imc) + " | Sobrepeso");
                igmResult.setImageResource(R.drawable.sobrepeso);
            } else if (imc >= 30 && imc < 34.9) {
                lbIMC.setText("IMC: " + String.format("%.2f", imc) + " | Obesidade grau 1");
                igmResult.setImageResource(R.drawable.obesidade1);
            } else if (imc >= 35 && imc < 39.9) {
                lbIMC.setText("IMC: " + String.format("%.2f", imc) + " | Obesidade grau 2");
                igmResult.setImageResource(R.drawable.obesidade2);
            } else {
                lbIMC.setText("IMC: " + String.format("%.2f", imc) + " | Obesidade grau 3");
                igmResult.setImageResource(R.drawable.obesidade3);
            }
        }
}
