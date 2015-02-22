package com.examples.lvasanga.asteroides;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Vector;


public class MainActivity extends ActionBarActivity {

    private Button bAcercaDe;
    public static AlmacenPuntuaciones almacen = new AlmacenPuntuacionesArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bAcercaDe =(Button) findViewById(R.id.button3);
        bAcercaDe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarAcercaDe(null);
            }
        });
    }
    public void salir(View view){
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.acercaDe) {
            lanzarAcercaDe(null);
            return true;
        }
       if(id == R.id.preferencias){
        lanzarPreferencias(null);
        return true;
    }
        return super.onOptionsItemSelected(item);
    }

    /**método en la clase Asteroides.java
     *  que será ejecutado cuando sea pulsado el botón Acercade
     */

    public void lanzarAcercaDe(View view){
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }
    public void lanzarPreferencias(View view){
        Intent i = new Intent(this, Preferencias.class);
        startActivity(i);
    }
    public void mostrarPreferencias(View view){
        SharedPreferences pref =
                PreferenceManager.getDefaultSharedPreferences(this);
        String s = "música: "+ pref.getBoolean("musica",true)
                +", gráficos: " + pref.getString("graficos","?");
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
    public static class AlmacenPuntuacionesArray implements AlmacenPuntuaciones{
        private Vector<String> puntuaciones;
        public AlmacenPuntuacionesArray() {
            puntuaciones= new Vector<String>();
            puntuaciones.add("123000 Pepito Domingez");
            puntuaciones.add("111000 Pedro Martinez");
            puntuaciones.add("011000 Paco Pérez");
        }
        @Override public void guardarPuntuacion(int puntos, String nombre, long fecha) {
            puntuaciones.add(0, puntos + " "+ nombre);
        }
        @Override public Vector<String> listaPuntuaciones(int cantidad) {
            return  puntuaciones;
        }
    }

    public void lanzarPuntuaciones(View view) {
        Intent i = new Intent(this, Puntuaciones.class);
        startActivity(i);
    }
    public void lanzarJuego(View view) {
        Intent i = new Intent(this, Juego.class);
        startActivity(i);
    }


}
