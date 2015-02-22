package com.examples.lvasanga.asteroides;

import java.util.Vector;

/**
 * Created by Alvaro on 22/02/2015.
 */
public interface AlmacenPuntuaciones {
        public void guardarPuntuacion(int puntos,String nombre,long fecha);
        public Vector<String> listaPuntuaciones(int cantidad);
}
