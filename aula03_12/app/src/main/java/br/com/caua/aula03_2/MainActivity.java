package br.com.caua.aula03_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg = (EditText) findViewById(R.id.edMessage);

        Button btn = (Button) findViewById(R.id.btnSend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciaActivityB(view);
            }
        });
    }
    public void iniciaActivityB(View v){
        Intent i = new Intent(this, ActivityB.class);
        String menssagem = String.valueOf(msg.getText());
        i.putExtra("msg", menssagem);
        startActivity(i);
    }

}