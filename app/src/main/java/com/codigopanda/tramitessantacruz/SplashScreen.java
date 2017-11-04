package com.codigopanda.tramitessantacruz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    int tiempo = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fsplashscreen);

        TimerTask t = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,
                        clsPrincipal.class));
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(t, tiempo);

    }
}
