package br.com.caua.aula03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import br.com.caua.aula03.control.DAOPessoa;
import br.com.caua.aula03.model.MPessoa;

public class MainActivity extends AppCompatActivity {
    DAOPessoa FDAOPessoa = new DAOPessoa();
    MPessoa   FMPessoa   = new MPessoa();
    EditText edEmail;
    EditText edNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FDAOPessoa = FDAOPessoa.getFDAOPessoa();
        edEmail = (EditText) findViewById(R.id.edEmail);
        edNome = (EditText) findViewById(R.id.edNome);

        Button btnCad = (Button) findViewById(R.id.btnCAD);
        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FMPessoa.setFEMAIL(String.valueOf(edEmail.getText()));
                FMPessoa.setFNOME(String.valueOf(edNome.getText()));
                FDAOPessoa.insert(FMPessoa);
                Log.d("add","Adicionado uma pessoa");
            }
        });

        Button btnPrint = (Button) findViewById(R.id.btnPrint);
        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<MPessoa> TListPessoa = new ArrayList<>();
                TListPessoa = FDAOPessoa.getList();
                for (MPessoa l : TListPessoa) {
                    Log.d("addList", "Email: " + l.getFEMAIL() + " Nome: " + l.getFNOME());
                }
            }
        });
    }
}