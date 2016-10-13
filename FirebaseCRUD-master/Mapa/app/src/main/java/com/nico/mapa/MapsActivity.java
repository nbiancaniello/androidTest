package com.nico.mapa;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

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

    }
}
