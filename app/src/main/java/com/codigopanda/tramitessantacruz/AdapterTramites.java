package com.codigopanda.tramitessantacruz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by victor on 04-11-17.
 */

public class AdapterTramites extends BaseAdapter {
    List<tramite> lista;
    LayoutInflater inflater;
    Context cx;


    public AdapterTramites(List<tramite> l, Context c) {
        lista= l;
        cx=c;
        inflater=(LayoutInflater) cx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class Holder{
        public ImageView imagen;
        public TextView titulo;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = inflater.inflate(R.layout.item_tramite,null);
        Holder h= new Holder();
        h.imagen=(ImageView) v.findViewById(R.id.imagenitemtramite);
        h.titulo=(TextView) v.findViewById(R.id.tituloitemtramite);
        h.imagen.setImageResource(lista.get(i).icono);
        h.titulo.setText(lista.get(i).titulo);

        return v;
    }
}
