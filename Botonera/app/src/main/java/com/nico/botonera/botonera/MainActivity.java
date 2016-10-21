package com.nico.botonera.botonera;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton1 = (Button) this.findViewById(R.id.boton1_play);
        Button boton2 = (Button) this.findViewById(R.id.boton1_stop);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.baileconungay);

        boton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
            }
        });
    }
}
