package com.nico.mapa;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static java.lang.Math.abs;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkCoordinates(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        EditText latitude = (EditText) findViewById(R.id.box_latitude);
        EditText longitude = (EditText) findViewById(R.id.box_longitude);
        Bundle extras = new Bundle();

        extras.putString("LATITUDE", latitude.getText().toString());
        extras.putString("LONGITUDE", longitude.getText().toString());
        intent.putExtras(extras);
        intent.setClassName(this,"com.nico.mapa.MapsActivity");
        startActivityForResult(intent,REQUEST_CODE);

//        Coordenadas de CABA
//        Latitud: 34.604° Sur
//        Longitud: 58.382° Oeste

    }

    public void getAddress(View view){

        EditText latitude = (EditText) findViewById(R.id.box_latitude);
        EditText longitude = (EditText) findViewById(R.id.box_longitude);
        try {
            Geocoder geo = new Geocoder(getApplicationContext(), Locale.getDefault());
            List<Address> addresses = geo.getFromLocation(Double.valueOf(String.valueOf(latitude.getText())),Double.valueOf(String.valueOf(longitude.getText())), 1);
            if (addresses.isEmpty()) {
                Toast.makeText(getApplicationContext(), R.string.novalidaddress, Toast.LENGTH_SHORT).show();
            } else {
                if (addresses.size() > 0) {
//                            Log.d("ADDRESS", addresses.get(0).getAddressLine(0) + ", " + // Dirección Completa
//                                    addresses.get(0).getLocality() +", " +  // Localidad
//                                    addresses.get(0).getAdminArea() + ", " +  // Municipìo
//                                    addresses.get(0).getCountryName()); // País

                    TextView text = (TextView) findViewById(R.id.text_addressshown);
                    text.setText(addresses.get(0).getAddressLine(0) + ", " + // Dirección Completa
                            addresses.get(0).getLocality() +", " +  // Localidad
                            addresses.get(0).getAdminArea() + ", " +  // Municipìo
                            addresses.get(0).getCountryName()); // País
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void getCurrentAddress(View view){
//
//        EditText latitude = (EditText) findViewById(R.id.box_latitude);
//        EditText longitude = (EditText) findViewById(R.id.box_longitude);
//        try {
//            Geocoder geo = new Geocoder(getApplicationContext(), Locale.getDefault());
//            List<Address> addresses = geo.getFromLocation(Double.valueOf(String.valueOf(latitude.getText())),Double.valueOf(String.valueOf(longitude.getText())), 1);
//            if (addresses.isEmpty()) {
//                Log.d("ADDRESS", "Waiting for Location");
//            } else {
//                if (addresses.size() > 0) {
////                            Log.d("ADDRESS", addresses.get(0).getAddressLine(0) + ", " + // Dirección Completa
////                                    addresses.get(0).getLocality() +", " +  // Localidad
////                                    addresses.get(0).getAdminArea() + ", " +  // Municipìo
////                                    addresses.get(0).getCountryName()); // País
//
//                    TextView text = (TextView) findViewById(R.id.text_addressshown);
//                    text.setText(addresses.get(0).getAddressLine(0) + ", " + // Dirección Completa
//                            addresses.get(0).getLocality() +", " +  // Localidad
//                            addresses.get(0).getAdminArea() + ", " +  // Municipìo
//                            addresses.get(0).getCountryName()); // País
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Log.d("LATITUDE", data.getStringExtra("LATITUDE"));
                Log.d("LONGITUDE", data.getStringExtra("LONGITUDE"));

                try {
                    Geocoder geo = new Geocoder(getApplicationContext(), Locale.getDefault());
                    List<Address> addresses = geo.getFromLocation(Double.valueOf(data.getStringExtra("LATITUDE")),Double.valueOf(data.getStringExtra("LONGITUDE")), 1);
                    if (addresses.isEmpty()) {
                        Toast.makeText(getApplicationContext(), R.string.novalidaddress, Toast.LENGTH_SHORT).show();
                    } else {
                        if (addresses.size() > 0) {
//                            Log.d("ADDRESS", addresses.get(0).getAddressLine(0) + ", " + // Dirección Completa
//                                    addresses.get(0).getLocality() +", " +  // Localidad
//                                    addresses.get(0).getAdminArea() + ", " +  // Municipìo
//                                    addresses.get(0).getCountryName()); // País

                            TextView text = (TextView) findViewById(R.id.text_addressshown);
                            text.setText(addresses.get(0).getAddressLine(0) + ", " + // Dirección Completa
                                    addresses.get(0).getLocality() +", " +  // Localidad
                                    addresses.get(0).getAdminArea() + ", " +  // Municipìo
                                    addresses.get(0).getCountryName()); // País

                            EditText latitude = (EditText) findViewById(R.id.box_latitude);
                            EditText longitude = (EditText) findViewById(R.id.box_longitude);

                            latitude.setText(data.getStringExtra("LATITUDE"));
                            longitude.setText(data.getStringExtra("LONGITUDE"));
                        }
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(getApplicationContext(), R.string.novalidaddress, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), R.string.novalidaddress, Toast.LENGTH_SHORT).show();
        }
    }
}
