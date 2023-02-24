package com.caua.aula02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText wN1;
    private EditText wN2;
    private EditText wResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Atribuindo ID dos Objetos
        wN1     = (EditText) findViewById(R.id.edN1);
        wN2     = (EditText) findViewById(R.id.edN2);
        wResult = (EditText) findViewById(R.id.edResult);

        Button btAdd = (Button) findViewById(R.id.btAdicao);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer n1 = Integer.valueOf(String.valueOf(wN1.getText()));
                Integer n2 = Integer.valueOf(String.valueOf(wN2.getText()));
                wResult.setText(String.valueOf(getSoma(n1,n2)));
            }
        });

        Button btMenos = (Button) findViewById(R.id.btMenos);
        btMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer n1 = Integer.valueOf(String.valueOf(wN1.getText()));
                Integer n2 = Integer.valueOf(String.valueOf(wN2.getText()));
                wResult.setText(String.valueOf(getMenos(n1,n2)));
            }
        });

        Button btVezes = (Button) findViewById(R.id.btVezes);
        btVezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer n1 = Integer.valueOf(String.valueOf(wN1.getText()));
                Integer n2 = Integer.valueOf(String.valueOf(wN2.getText()));
                wResult.setText(String.valueOf(getVezes(n1,n2)));
            }
        });

        Button btDivide = (Button) findViewById(R.id.btDividir);
        btDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer n1 = Integer.valueOf(String.valueOf(wN1.getText()));
                Integer n2 = Integer.valueOf(String.valueOf(wN2.getText()));
                wResult.setText(String.valueOf(getDivisao(n1,n2)));
            }
        });
    }
    private Float getSoma(Integer prN1, Integer prN2){
        return Float.valueOf((prN1 + prN2));
    }
    private Float getMenos(Integer prN1, Integer prN2){
        return Float.valueOf((prN1 - prN2));
    }
    private Float getVezes(Integer prN1, Integer prN2){
        return Float.valueOf((prN1 * prN2));
    }
    private Float getDivisao(Integer prN1, Integer prN2){
        return Float.valueOf((prN1 / prN2));
    }
}