package com.nico.mapa;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Math.abs;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarCoordenadas(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        EditText latitud = (EditText) findViewById(R.id.box_latitude);
        EditText longitud = (EditText) findViewById(R.id.box_longitude);
        Bundle extras = new Bundle();

        extras.putString("LATITUDE", latitud.getText().toString());
        extras.putString("LONGITUDE", longitud.getText().toString());
        intent.putExtras(extras);
        intent.setClassName(this,"com.nico.mapa.MapsActivity");
        startActivity(intent);

//        Coordenadas de CABA
//        Latitud: 34.604° Sur
//        Longitud: 58.382° Oeste

    }
}
