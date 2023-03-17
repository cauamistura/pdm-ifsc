package br.com.caua.aula04;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edPeso;
    private EditText edAltura;
    private TextView lbIMC;
    private Button   btnCalc;
    private ImageView imgPrinc;
    private ImageView igmResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPrinc  = findViewById(R.id.imagerPrinc);
        igmResult = findViewById(R.id.imgResult);

        edPeso   = findViewById(R.id.edPeso);
        edAltura = findViewById(R.id.edAltura);
        lbIMC    = findViewById(R.id.lbImc);
        btnCalc  = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double peso = Double.parseDouble(edPeso.getText().toString());
                double altura = Double.parseDouble(edAltura.getText().toString());

                double imc = peso / (altura * altura);
                if (imc < 18.5){
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
                } else if (imc >= 35  && imc < 39.9) {
                    lbIMC.setText("IMC: " + String.format("%.2f", imc) + " | Obesidade grau 2");
                    igmResult.setImageResource(R.drawable.obesidade2);
                } else {
                    lbIMC.setText("Obesidade grau 3");
                    igmResult.setImageResource(R.drawable.obesidade3);
                }
            }
        });
    }
}
