package com.example.questao_6;

import static java.lang.String.valueOf;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button btn = (Button) findViewById(R.id.btnCount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextView lbCount = (TextView) findViewById(R.id.lbCount);
                lbCount.setText("Fui Clicado!!");
            }
        });

        final Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView lbNum = (TextView) findViewById(R.id.lbnum);
                final EditText edN1 = (EditText) findViewById(R.id.edn1);
                final EditText edN2 = (EditText) findViewById(R.id.edn2);
                Integer n1 = Integer.valueOf(valueOf(edN1.getText()));
                Integer n2 = Integer.valueOf(valueOf(edN2.getText()));
                lbNum.setText(valueOf(getRandomInt(n1,n2)));
            }
        });
    }
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}