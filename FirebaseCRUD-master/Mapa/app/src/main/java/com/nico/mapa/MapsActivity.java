package com.nico.mapa;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;
    private LatLng position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button demo = (Button) this.findViewById(R.id.demo);
        demo.setOnClickListener(devolverCoordenadas);
    }

    View.OnClickListener devolverCoordenadas = new View.OnClickListener() {
        public void onClick(View v) {
            Log.i("Posicion", String.format("Drag final %f:%f",
                    position.latitude,
                    position.longitude));

            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
            Bundle extras = new Bundle();

            extras.putString("LATITUDE", String.valueOf(position.latitude));
            extras.putString("LONGITUDE", String.valueOf(position.longitude));
            intent.putExtras(extras);
            intent.setClassName(getApplicationContext(),"com.nico.mapa.MainActivity");
//            startActivity(intent);
            setResult(RESULT_OK, intent);
            finish();
        }
    };

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        // Add a marker in Sydney and move the camera
        LatLng coordenates = new LatLng(Double.valueOf(extras.getString("LATITUDE")),Double.valueOf(extras.getString("LONGITUDE")));
        mMap.addMarker(new MarkerOptions().position(coordenates).draggable(true).title("Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coordenates));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(14));

        mMap.setOnMarkerDragListener(this);
    }


    public void onMarkerDragStart(Marker marker) {
        position=marker.getPosition();

        Log.d(getClass().getSimpleName(), String.format("Drag from %f:%f",
                position.latitude,
                position.longitude));
    }

    public void onMarkerDrag(Marker marker) {
        position=marker.getPosition();

        Log.d(getClass().getSimpleName(),
                String.format("Dragging to %f:%f", position.latitude,
                        position.longitude));
    }

    public void onMarkerDragEnd(Marker marker) {
        position=marker.getPosition();

        Log.d(getClass().getSimpleName(), String.format("Dragged to %f:%f",
                position.latitude,
                position.longitude));
    }
}
