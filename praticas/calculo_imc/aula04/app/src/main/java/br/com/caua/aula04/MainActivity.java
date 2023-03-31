package br.com.caua.aula04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import br.com.caua.aula04.Resultado;


public class MainActivity extends AppCompatActivity {

    private EditText edPeso;
    private EditText edAltura;
    private Button   btnCalc;
    private ImageView imgPrinc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPrinc  = findViewById(R.id.imagerPrinc);
        edPeso   = findViewById(R.id.edPeso);
        edAltura = findViewById(R.id.edAltura);
        btnCalc  = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double peso = Double.parseDouble(edPeso.getText().toString());
                double altura = Double.parseDouble(edAltura.getText().toString());

                double imc = peso / (altura * altura);
                iniciaActivityResultado(view, imc);
            }
        });
    }
    public void iniciaActivityResultado(View v, double prImc){
        Intent i = new Intent(this, Resultado.class);
        double imc = prImc;
        i.putExtra("imc", imc);
        startActivity(i);
    }
}
