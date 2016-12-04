package com.nico.botonera.botonera;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button boton1;
    Button boton2;
    Button boton3;
    Button boton4;
    Button bPhapuh;
    MediaPlayer mp1;
    MediaPlayer mp2;
    MediaPlayer mp3;
    MediaPlayer mp4;
    MediaPlayer mpPhapuh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = (Button) this.findViewById(R.id.boton1_play);
        boton2 = (Button) this.findViewById(R.id.boton2_play);
        boton3 = (Button) this.findViewById(R.id.boton3_play);
        boton4 = (Button) this.findViewById(R.id.boton4_play);
        bPhapuh = (Button) this.findViewById(R.id.phapuh);
        mp1 = MediaPlayer.create(this, R.raw.laverdaderagira);
        mp2 = MediaPlayer.create(this, R.raw.pahpuhdondeestan);
        mp3 = MediaPlayer.create(this, R.raw.tantoquelaagitas);
        mp4 = MediaPlayer.create(this, R.raw.ysugira);
        mpPhapuh = MediaPlayer.create(this, R.raw.phapuh);

        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mp1.start();
            }

        });

        boton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mp2.start();
            }

        });

        boton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mp3.start();
            }

        });

        boton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mp4.start();
            }

        });

        bPhapuh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mpPhapuh.start();
            }

        });
    }
}
