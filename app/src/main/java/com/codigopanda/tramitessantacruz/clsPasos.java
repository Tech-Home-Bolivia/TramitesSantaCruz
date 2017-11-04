package com.codigopanda.tramitessantacruz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class clsPasos extends AppCompatActivity {

    TextView titulo;
    TextView detalle;
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fpasos);
        titulo=(TextView) findViewById(R.id.titulodetramitepasos);
        detalle=(TextView) findViewById(R.id.detalledetramitepasos);
        lista=(ListView) findViewById(R.id.listadepasos);

        titulo.setText("Pasos para "+GLobalDatos.pasotramite.titulo);
        detalle.setText(GLobalDatos.pasotramite.detalle);


        ArrayAdapter adap = new ArrayAdapter(clsPasos.this
                ,android.R.layout.simple_list_item_1
                ,getListaTituloPasos());

        lista.setAdapter(adap);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                GLobalDatos.paso=GLobalDatos.listadepasos.get(i);
                startActivity(new Intent(clsPasos.this,clsDetallePaso.class));
            }
        });
    }

    public List<String> getListaTituloPasos(){
        List<String> cad= new ArrayList<>();
        for(int i=0;i<GLobalDatos.listadepasos.size();i++){
            cad.add(GLobalDatos.listadepasos.get(i).titulo);
        }
        return cad;
    }

}
