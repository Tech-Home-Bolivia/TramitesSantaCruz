package com.codigopanda.tramitessantacruz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class clsPrincipal extends AppCompatActivity {

    List<tramite> trami = new ArrayList<>();
    List<Paso> pasos = new ArrayList<>();

    ListView listatramite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fprincipal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CargarTramites();
        CargarPasos();

        listatramite = (ListView) findViewById(R.id.listadetramites);

        AdapterTramites adap = new AdapterTramites(trami, clsPrincipal.this);
        listatramite.setAdapter(adap);

        listatramite.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                tramite tra = trami.get(position);
                GLobalDatos.pasotramite = tra;
                GLobalDatos.listadepasos = PasosdeTramite(tra.id);
                startActivity(new Intent(clsPrincipal.this, clsPasos.class));
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void CargarTramites() {
        trami.add(new tramite(1, R.drawable.imagen1, "Carnet", "detalle"));
        trami.add(new tramite(2, R.drawable.imagen2, "Divorsio", "detalle"));

    }

    public void CargarPasos() {
        pasos.add(new Paso(1, "Sacar " +
                "certificado nacimiento", "Ir al registro civil mas cercano", "-17.783634", "-63.183792"));
        pasos.add(new Paso(1, "Segib", "hacer cola", "123123", "213123"));
    }

    public List<Paso> PasosdeTramite(int idtramite) {
        List<Paso> lista = new ArrayList<>();
        for (int i = 0; i < pasos.size(); i++) {
            if (idtramite == pasos.get(i).idtramite) {
                lista.add(pasos.get(i));
            }
        }
        return lista;
    }

    public List<tramite> BuscarTramite(String cad) {
        List<tramite> lista = new ArrayList<>();
        for (int i = 0; i < trami.size(); i++) {
            if (trami.get(i).titulo.compareTo(cad) == 0) {
                lista.add(trami.get(i));
            }
        }
        return lista;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cls_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(clsPrincipal.this,
                    "Hola soy settings", Toast.LENGTH_LONG).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
