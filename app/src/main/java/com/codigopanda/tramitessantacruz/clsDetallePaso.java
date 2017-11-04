package com.codigopanda.tramitessantacruz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class clsDetallePaso extends AppCompatActivity {
    TextView titulo;
    TextView detalle;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fdetallepaso);
        titulo=(TextView) findViewById(R.id.detallepasotitulo);
        detalle=(TextView) findViewById(R.id.detallepasodetalle);
        boton=(Button) findViewById(R.id.botonsaltarmapa);

        titulo.setText(GLobalDatos.paso.titulo);
        detalle.setText(GLobalDatos.paso.detalle);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(clsDetallePaso.this,clsMapa.class));
            }
        });

    }
}
