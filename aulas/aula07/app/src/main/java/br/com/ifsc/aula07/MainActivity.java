package br.com.ifsc.aula07;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.ifsc.aula07.model.AppsAdapter;

public class MainActivity extends AppCompatActivity {
    ListView list;
    PackageManager pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);
        pm = getPackageManager();

        //Pegando nomes dos apps instalados no sistemas
        ArrayList<String> appsNames= new ArrayList<>();
        List<ApplicationInfo> apps = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo app: apps) {
            appsNames.add(app.loadLabel(pm).toString());
        }

        //Criando adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, appsNames);

        //Adaptador Personalizado
        AppsAdapter adapterPersonalizado = new AppsAdapter(this, R.layout.list_layout, apps);

        //Setando o adapter
        list.setAdapter(adapterPersonalizado);
    }
}