package com.nico.mapa;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String ALTITUD = "0";
    public final static String LATITUD = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarCoordenadas(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        EditText caltitud = (EditText) findViewById(R.id.caja_altitud);
        EditText clatitud = (EditText) findViewById(R.id.caja_latitud);
        intent.putExtra(ALTITUD, caltitud.getText().toString());
        intent.putExtra(LATITUD, clatitud.getText().toString());
//        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.setClassName(this,"com.nico.mapa.MapsActivity");
        startActivity(intent);
    }
}
