package br.com.caua.aula03_2;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends MainActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityb);

        TextView lbMSG = (TextView) findViewById(R.id.lbMSG);

        Bundle bundle = getIntent().getExtras();
        String msg = bundle.getString("msg");

        lbMSG.setText(msg);
    }
}
