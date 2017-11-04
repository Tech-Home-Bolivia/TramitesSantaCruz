package com.codigopanda.tramitessantacruz;

/**
 * Created by victor on 28-10-17.
 */

public class Paso {
    public int idtramite;
    public String titulo;
    public String detalle;
    public String latitud;
    public String longitud;

    public Paso(int idtramite,String titulo,String detalle,String latitud,String longitud){
        this.idtramite=idtramite;
        this.titulo=titulo;
        this.detalle=detalle;
        this.longitud=longitud;
        this.latitud=latitud;
    }
}
