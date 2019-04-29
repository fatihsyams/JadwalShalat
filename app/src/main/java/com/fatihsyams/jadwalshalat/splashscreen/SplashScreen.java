package com.fatihsyams.jadwalshalat.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fatihsyams.jadwalshalat.MainActivity;
import com.fatihsyams.jadwalshalat.R;



public class SplashScreen extends AppCompatActivity {

    private int waktu_loading=4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        customActionBar();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent home=new Intent(SplashScreen.this, MainActivity.class);
                startActivity(home);
                finish();

            }
        },waktu_loading);
    }

    private void customActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
