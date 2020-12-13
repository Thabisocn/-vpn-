package com.nextgen_io.io_vpn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashscreenActivity extends AppCompatActivity {

    Thread timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        timer = new Thread(){
            @Override
            public void run() {
                try {
                    synchronized (this){
                        wait(5000);
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashscreenActivity.this, AppIntro.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();

    }
}